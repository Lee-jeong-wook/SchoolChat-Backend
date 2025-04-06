package team.react.school_chat.domain.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import team.react.school_chat.domain.chat.domain.Chat;
import team.react.school_chat.domain.chat.dto.ChatDTO
import team.react.school_chat.domain.chat.service.ChatRoomService
import team.react.school_chat.domain.chat.service.ChatService

@RestController
public class ChatController(private val messagingTemplate: SimpMessagingTemplate, private val chatRoomService: ChatRoomService,private val chatService: ChatService) {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/{roomId}")
    fun sendMessage(@Payload chatDTO: ChatDTO) {
        val chatRoom = chatRoomService.findChatRoom(chatDTO.chatRoom,chatDTO.memberId)

        val chat = Chat(
            content = chatDTO.content,
            userName = chatDTO.userName,
            memberId = chatDTO.memberId,
            chatRoom = chatRoom
        )

        chatService.saveChat(chat);
        messagingTemplate.convertAndSend("/topic/${chat.chatRoom.id}", chat)
    }
}
