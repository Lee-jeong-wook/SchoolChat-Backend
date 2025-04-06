package team.react.school_chat.global.exception

class CustomException(val errorCode: ErrorCode, val details: String = ""): RuntimeException() {}