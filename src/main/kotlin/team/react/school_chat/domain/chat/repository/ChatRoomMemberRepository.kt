package team.react.school_chat.domain.chat.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import team.react.school_chat.domain.chat.domain.ChatRoom
import team.react.school_chat.domain.chat.domain.ChatRoomMember

@Repository
interface ChatRoomMemberRepository : JpaRepository<ChatRoomMember, Long> {

    @Query("SELECT c FROM ChatRoom c JOIN ChatRoomMember m WHERE m.member.email = :memberEmail")
    fun findAllChatRoomByMemberEmail(memberEmail: String): List<ChatRoom>

}