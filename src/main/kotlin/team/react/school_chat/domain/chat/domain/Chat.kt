package team.react.school_chat.domain.chat.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "chat")
data class Chat(
        @Id
        @Column(name = "id", nullable = false)
        val id: String,

        @Column(name = "member_email", nullable = false)
        val memberId: Long,

        @Column(name = "user_name", nullable = false)
        val userName: String,

        @Column(name = "content", nullable = false)
        val content: String,

        @CreatedDate
        @Column(name = "created_at", nullable = false)
        var createTime: LocalDateTime,

        @ManyToOne(cascade = [(CascadeType.ALL)])
        @JoinColumn(name = "room_id")
        val chatRoom: ChatRoom
)