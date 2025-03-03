package team.react.school_chat.domain.chat.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.domain.chat.domain.ChatRoom

interface ChatRoomRepository:JpaRepository<ChatRoom, Long> {
}