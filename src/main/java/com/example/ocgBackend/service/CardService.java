package com.example.ocgBackend.service;

import com.example.ocgBackend.persistence.repositories.CardRepository;
import com.example.ocgBackend.persistence.repositories.UserRepository;
import com.example.ocgBackend.rest.api.dto.CardsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.example.ocgBackend.base.util.BigDecimalUtil.getBigDecimal;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity getAllCards() {
        return ResponseEntity.ok(
                cardRepository.findAll()
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
        );
    }
    public ResponseEntity getCardsByUser(Long userId) {
        return ResponseEntity.ok(
                userRepository.findById(userId)
                        .orElseThrow()
                        .getUserCards()
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
        );
    }
}
