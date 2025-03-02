package team.react.school_chat.auth.dto

import team.react.school_chat.auth.domain.Member

data class MemberDTO(
    val email: String,
    val name: String,
    val picture: String
) {
    fun toEntity(): Member = Member(email, name, picture)
}
