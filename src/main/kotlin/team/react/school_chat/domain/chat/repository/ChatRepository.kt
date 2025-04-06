package team.react.school_chat.domain.chat.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import team.react.school_chat.domain.chat.domain.Chat

@Repository
interface ChatRepository: JpaRepository<Chat, Long> {
    @Query("select c from Chat c where c.chatRoom.id = :chatRoomId")
    fun findAllChatByChatRoomId(chatRoomId: Long): List<Chat>
}