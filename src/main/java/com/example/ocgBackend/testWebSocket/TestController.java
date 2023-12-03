package com.example.ocgBackend.testWebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class TestController {

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public TestDto greet(TestDto message) throws InterruptedException {
        Thread.sleep(2000);
        return new TestDto(
                HtmlUtils.htmlEscape(
                        message.getTxt())
        );
    }
}
