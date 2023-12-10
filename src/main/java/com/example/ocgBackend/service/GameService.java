package com.example.ocgBackend.service;

import com.example.ocgBackend.persistence.model.Room;
import com.example.ocgBackend.persistence.model.User;
import com.example.ocgBackend.persistence.repositories.RoomRepository;
import com.example.ocgBackend.persistence.repositories.UserRepository;
import com.example.ocgBackend.rest.api.dto.RoomState;
import com.example.ocgBackend.rest.api.dto.SessionDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class GameService implements ApplicationRunner {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    private final static String subscribe = "/game-get/result";
    private final static String send = "/send";
    private final static String route = "";

    public List<Room> getRoomsByState() {
           List<Room> rooms = roomRepository.findAllByState(RoomState.READY);
           if(rooms.isEmpty()) {
               rooms = roomRepository.findAllByState(RoomState.EMPTY);
           }
           return rooms;
    }

    @Transactional
    public ResponseEntity getSessionDto(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Room room = connectUser(user);
        String route = Base64.getEncoder().encodeToString((room.getName()+user.getName()).getBytes());
        return ResponseEntity.ok( new SessionDto()
                .socket(room.getName())
                .subscribe(subscribe)
                .send(send)
                .route(route));
    }

    @Transactional
    public Room connectUser(User user) {
        List<Room> rooms = roomRepository.findAllByState(RoomState.READY);
        if(!rooms.isEmpty()){
            rooms.get(0).setUserTwo(user);
            rooms.get(0).setState(RoomState.FULL);
        }else {
            rooms = roomRepository.findAllByState(RoomState.EMPTY);
            if(!rooms.isEmpty()) {
                rooms.get(0).setUserOne(user);
                rooms.get(0).setState(RoomState.READY);
            }
        }
        roomRepository.saveAll(rooms);
        return rooms.get(0);
    }

    @Transactional
    public void setEmptyState(){
        List<Room> rooms = roomRepository.findAll();
        rooms.forEach(room ->
            room.setState(RoomState.EMPTY));
        roomRepository.saveAll(rooms);
    }

    @Transactional
    public void disconnectUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Optional<Room> optionalRoom = roomRepository.findByUserOne(user);
        Room room;
        if(optionalRoom.isEmpty()) {
            optionalRoom = roomRepository.findByUserTwo(user);
            room = optionalRoom.orElseThrow();
            room.setUserTwo(null);
        }
        else {
            room = optionalRoom.orElseThrow();
            room.setUserOne(null);
        }
        roomRepository.save(room);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        setEmptyState();
    }
}
