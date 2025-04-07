package team.react.school_chat.domain.chat.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "chat")
data class Chat(
        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "member_email", nullable = false)
        val memberId: String,

        @Column(name = "user_name", nullable = false)
        val userName: String,

        @Column(name = "content", nullable = false)
        val content: String,

        @CreatedDate
        @Column(name = "created_at", nullable = false)
        var createTime: LocalDateTime? = null,

        @ManyToOne()
        @JoinColumn(name = "room_id")
        val chatRoom: ChatRoom
)