package team.react.school_chat.auth.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.auth.domain.Friend
import team.react.school_chat.auth.domain.FriendId

interface FriendRepository: JpaRepository<Friend, FriendId> {
}