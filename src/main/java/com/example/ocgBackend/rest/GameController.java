package com.example.ocgBackend.rest;

import com.example.ocgBackend.rest.api.GameApi;
import com.example.ocgBackend.rest.api.GameApiDelegate;
import com.example.ocgBackend.rest.api.dto.SessionDto;
import com.example.ocgBackend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class GameController implements GameApi, GameApiDelegate {

    @Autowired
    private GameService gameService;

    @Override
    public ResponseEntity<SessionDto> connect(BigDecimal userId) {
        return gameService.getSessionDto(userId.longValue());
    }

    @Override
    public ResponseEntity<Void> disconnectUser(BigDecimal userId) {
        gameService.disconnectUser(userId.longValue());
        return GameApi.super.disconnectUser(userId);
    }

    @Override
    public GameApiDelegate getDelegate() {
        return GameApi.super.getDelegate();
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return GameApiDelegate.super.getRequest();
    }


}
