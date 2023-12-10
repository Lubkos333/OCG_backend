package com.example.ocgBackend.rest;

import com.example.ocgBackend.rest.api.CardsApi;
import com.example.ocgBackend.rest.api.CardsApiDelegate;
import com.example.ocgBackend.rest.api.dto.Cards;
import com.example.ocgBackend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CardController implements CardsApi, CardsApiDelegate {

    @Autowired
    private CardService cardService;

    @Override
    public ResponseEntity<Cards> getAllCards() {
        return cardService.getAllCards();
    }

    @Override
    public ResponseEntity<Cards> getCardsByUserID(BigDecimal userId) {
        return cardService.getCardsByUser(userId.longValue());
    }

    @Override
    public CardsApiDelegate getDelegate() {
        return CardsApi.super.getDelegate();
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return CardsApiDelegate.super.getRequest();
    }

}
