package com.example.ocgBackend.service;

import com.example.ocgBackend.persistence.model.User;
import com.example.ocgBackend.persistence.repositories.UserRepository;
import com.example.ocgBackend.rest.api.dto.CardsDto;
import com.example.ocgBackend.rest.api.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.example.ocgBackend.base.util.BigDecimalUtil.getBigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(
                userRepository.findAll()
                .stream()
                .map(user -> new UserDto()
                        .id(getBigDecimal(user.getId()))
                        .name(user.getName())
                        .vicroryCount(getBigDecimal(user.getVictoryCount()))
                        .email(user.getEmail())
                        .cards(
                                user.getUserCards()
                                        .stream()
                                        .map(
                                                card -> new CardsDto()
                                                        .id(getBigDecimal(card.getId()))
                                                        .name(card.getName())
                                                        .description(card.getDescription())
                                                        .value(getBigDecimal(card.getValue()))
                                                        .attack(getBigDecimal(card.getAttack()))
                                                        .image("")
                                        )
                                        .collect(Collectors.toList())
                        )
                        )
                );
    }

    public ResponseEntity onetimeLogin(String name) {
        if(userRepository.findByName(name).isEmpty()) {
            userRepository.save(User.builder()
                            .name(name)
                            .build()
            );
        }
        else {
            throw new RuntimeException("User with this name is already signed in");
        }
        return ResponseEntity.ok(
                modelMapper.map(userRepository.findByName(name).orElseThrow(), UserDto.class)
        );
    }
    public ResponseEntity getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return ResponseEntity.ok(
                new UserDto()
                    .id(getBigDecimal(user.getId()))
                    .name(user.getName())
                    .vicroryCount(getBigDecimal(user.getVictoryCount()))
                    .email(user.getEmail())
                    .cards(
                            user.getUserCards()
                                    .stream()
                                    .map(
                                            card -> new CardsDto()
                                                    .id(getBigDecimal(card.getId()))
                                                    .name(card.getName())
                                                    .description(card.getDescription())
                                                    .value(getBigDecimal(card.getValue()))
                                                    .attack(getBigDecimal(card.getAttack()))
                                                    .image("")
                                    )
                                    .collect(Collectors.toList())
                    )

        );
    }
}
