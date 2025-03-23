package team.react.school_chat.domain.chat.service

import org.springframework.stereotype.Service
import team.react.school_chat.domain.chat.domain.Chat
import team.react.school_chat.domain.chat.repository.ChatRepository
import team.react.school_chat.domain.chat.repository.ChatRoomMemberRepository

@Service
class ChatService(private val chatRepository: ChatRepository){
    fun saveChat(chat: Chat){
        chatRepository.save(chat);
    }
    fun findAllChatByMemberId(chatRoomId: Long): List<Chat>{
        val li:List<Chat> = chatRepository.findAllChatByChatRoomId(chatRoomId);
        return li;
    }
}