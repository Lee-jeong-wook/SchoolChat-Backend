package team.react.school_chat.domain.chat.domain

import jakarta.persistence.*
import team.react.school_chat.domain.member.domain.Member
import team.react.school_chat.domain.member.dto.MemberDTO

@Entity
data class ChatRoomMember(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "chat_room_id", nullable = false)
    val chatRoom: ChatRoom,

    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "member_email", nullable = false)
    val member: Member
)