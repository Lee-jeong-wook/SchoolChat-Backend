package team.react.school_chat.domain.chat.domain

import java.time.LocalDateTime

data class Chat(
        val id: String? = null,
        val userName: String? = null,
        val content: String? = null,
        var createTime: LocalDateTime? = LocalDateTime.now(),
        val roomId: String? = null
)