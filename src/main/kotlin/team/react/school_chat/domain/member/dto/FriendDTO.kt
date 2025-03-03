package team.react.school_chat.domain.member.dto

import team.react.school_chat.domain.member.domain.Friend
import team.react.school_chat.domain.member.domain.FriendId
import team.react.school_chat.domain.member.domain.Member

data class FriendDTO(
    val friendEmail: String,
    val friendName: String,
    val friendPicture: String
) {
    companion object {
        fun from(friend: Friend): FriendDTO =
            FriendDTO(
                friendEmail = friend.friend.email,
                friendName = friend.friend.name,
                friendPicture = friend.friend.picture
            )
    }

    fun toEntity(owner: Member): Friend {
        val friend = Member(
            email = friendEmail,
            name = friendName,
            picture = friendPicture
        )

        return Friend(
            id = FriendId(owner.email, friend.email),
            owner = owner,
            friend = friend
        )
    }
}
