package team.react.school_chat.auth.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/user")
class AuthController() {
    @GetMapping("/email")
    fun getUserEmail(authentication: Authentication): Map<String, String> {
        val response = mapOf("email" to authentication.name)
        return response
    }
}