package team.react.school_chat.domain.auth.dto

import team.react.school_chat.domain.auth.domain.Member

data class MemberUpdateRequest(
    val name: String,
    val picture: String
)
