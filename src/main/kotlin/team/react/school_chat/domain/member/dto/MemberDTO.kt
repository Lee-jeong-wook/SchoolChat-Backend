package team.react.school_chat.domain.member.dto

import team.react.school_chat.domain.member.domain.Member
import team.react.school_chat.domain.social.dto.FriendDTO

data class MemberDTO(
    val email: String,
    val name: String,
    val picture: String,
    val friends: List<FriendDTO> = listOf(),
) {
    companion object {
        fun from(member: Member): MemberDTO =
            MemberDTO(
                email = member.email,
                name = member.name,
                picture = member.picture,
                friends = member.friends.map { FriendDTO.from(it) }
            )
    }

    fun toEntity(): Member {
        val member = Member(
            email = email,
            name = name,
            picture = picture,
            friends = mutableListOf()
        )

        member.friends = friends.map { it.toEntity(member) }.toMutableList()

        return member
    }
}
