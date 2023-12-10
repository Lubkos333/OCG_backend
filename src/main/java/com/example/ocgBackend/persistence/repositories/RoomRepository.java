package com.example.ocgBackend.persistence.repositories;

import com.example.ocgBackend.persistence.model.Room;
import com.example.ocgBackend.persistence.model.User;
import com.example.ocgBackend.rest.api.dto.RoomState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByState(RoomState state);

    Optional<Room> findByUserOne(User userOne);
    Optional<Room> findByUserTwo(User userTwo);

}
