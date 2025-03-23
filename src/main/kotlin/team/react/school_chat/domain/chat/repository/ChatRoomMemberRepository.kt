package team.react.school_chat.domain.chat.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import team.react.school_chat.domain.chat.domain.ChatRoom
import team.react.school_chat.domain.chat.domain.ChatRoomMember

@Repository
interface ChatRoomMemberRepository : JpaRepository<ChatRoomMember, Long> {

    @Query("select c from ChatRoom c join ChatRoomMember m on c.id = m.chatRoomId where m.memberId = :memberId")
    fun findAllChatRoomByMemberId(memberId: String): List<ChatRoom>
}