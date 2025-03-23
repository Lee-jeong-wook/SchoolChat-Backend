package team.react.school_chat.domain.chat.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class ChatRoomMember (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "chatroom_id")
    val chatRoomId: Long,

    @Column(name = "member_email")
    val memberId: String
)