package team.react.school_chat.domain.chat.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import team.react.school_chat.domain.chat.domain.ChatRoom

@Repository
interface ChatRoomRepository : JpaRepository<ChatRoom, Long> {

    @Query("select c from ChatRoom c join ChatRoomMember m on c.id = m.chatRoom.id where c.id = :chatRoomId and m.member.email = :memberId")
    fun findChatRoomByMemberId(chatRoomId: Long, memberId: String): ChatRoom?
}