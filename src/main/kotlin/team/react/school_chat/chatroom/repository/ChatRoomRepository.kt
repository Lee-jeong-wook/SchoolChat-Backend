package team.react.school_chat.chatroom.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import team.react.school_chat.chatroom.ChatRoom

interface ChatRoomRepository:JpaRepository<ChatRoom, String> {
}