package team.react.school_chat.global.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(val httpStatus: HttpStatus, val message: String) {
    NOT_FOUND(HttpStatus.NOT_FOUND, "요청에 대한 결과를 찾을 수 없습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "요청에 대한 권한이 없습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "요청이 거부되었습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    ALREADY_EXIST(HttpStatus.CONFLICT, "이미 존재하는 리소스 입니다."),

}