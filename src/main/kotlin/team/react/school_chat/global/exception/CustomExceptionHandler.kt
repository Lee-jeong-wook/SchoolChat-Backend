package team.react.school_chat.global.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun handleException(exception: CustomException, request: HttpServletRequest): ResponseEntity<ErrorResponseBody> {
        return ErrorResponseEntity(exception).toResponseEntity()
    }
}