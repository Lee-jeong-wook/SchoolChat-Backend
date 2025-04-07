package team.react.school_chat.domain.social.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.domain.social.domain.Friend
import team.react.school_chat.domain.social.domain.FriendId

interface FriendRepository: JpaRepository<Friend, FriendId> {
}