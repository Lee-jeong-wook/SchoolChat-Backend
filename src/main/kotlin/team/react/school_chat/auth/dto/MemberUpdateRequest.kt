package team.react.school_chat.auth.dto

import team.react.school_chat.auth.domain.Member

data class MemberUpdateRequest(
    val name: String,
    val picture: String
)
