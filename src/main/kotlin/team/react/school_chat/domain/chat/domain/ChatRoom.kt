package team.react.school_chat.domain.chat.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import team.react.school_chat.domain.auth.domain.Member
import java.time.LocalDateTime

@Entity
@Table(name = "chat_room")
data class ChatRoom (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "room_id")
        val id : Long,

        @Column(name = "room_name")
        val name : String,

        @OneToMany(mappedBy = "email", cascade = [(CascadeType.ALL)], orphanRemoval = true)
        val chatMember: List<Member>,

        @CreatedDate
        val createAt: LocalDateTime
)