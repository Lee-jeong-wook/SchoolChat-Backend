package team.react.school_chat.domain.chat.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import team.react.school_chat.domain.member.domain.Member
import java.time.LocalDateTime

@Entity
@Table(name = "chat_room")
@EntityListeners(AuditingEntityListener::class)
data class ChatRoom (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "chat_room_id")
        val id : Long,

        @Column(name = "room_name")
        val name : String,
)