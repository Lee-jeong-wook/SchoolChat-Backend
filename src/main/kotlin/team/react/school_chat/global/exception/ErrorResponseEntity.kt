package team.react.school_chat.global.exception

import org.springframework.http.ResponseEntity

data class ErrorResponseEntity(val exception: CustomException) {
    private val errorCode = exception.errorCode

    fun toResponseEntity(): ResponseEntity<ErrorResponseBody> =
        ResponseEntity(
            ErrorResponseBody(
                this.errorCode.httpStatus.value(),
                this.errorCode.message,
                this.exception.details
            ),
            this.errorCode.httpStatus
        )
}
