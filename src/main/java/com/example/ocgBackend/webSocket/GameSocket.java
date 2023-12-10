package com.example.ocgBackend.webSocket;

import com.example.ocgBackend.rest.api.dto.GameDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameSocket {

    @MessageMapping("/send")
    @SendTo("/game-get/result")
    public GameDto gameMessaging(GameDto gameDto) {
        return gameDto;
    }
}
