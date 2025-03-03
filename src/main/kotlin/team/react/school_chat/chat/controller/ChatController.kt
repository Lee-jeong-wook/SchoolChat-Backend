package team.react.school_chat.chat.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import team.react.school_chat.chat.Chat;

@RestController
public class ChatController(private val messagingTemplate: SimpMessagingTemplate) {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/{roomId}")
    fun sendMessage(@Payload chat: Chat) {
        messagingTemplate.convertAndSend("/topic/${chat.roomId}", chat)
    }

}
