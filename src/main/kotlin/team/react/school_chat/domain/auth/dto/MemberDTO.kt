package team.react.school_chat.domain.auth.dto

import team.react.school_chat.domain.auth.domain.Member

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
