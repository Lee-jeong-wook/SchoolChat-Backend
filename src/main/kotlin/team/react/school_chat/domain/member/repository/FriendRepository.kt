package team.react.school_chat.domain.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.domain.member.domain.Friend
import team.react.school_chat.domain.member.domain.FriendId

interface FriendRepository: JpaRepository<Friend, FriendId> {
}