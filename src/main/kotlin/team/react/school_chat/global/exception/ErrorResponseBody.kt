package team.react.school_chat.global.exception

data class ErrorResponseBody(
    val status: Int,
    val message: String,
    val details: String
)
