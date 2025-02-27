package team.react.school_chat.auth.utils

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class OAuth2LoginSuccessHandler(
    private val jwtProvider: JwtProvider
) : AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val oAuth2User = authentication.principal as DefaultOAuth2User
        val email = oAuth2User.attributes["email"] as String // OAuth2에서 제공하는 email

        val token = jwtProvider.generateToken(email)

        response.contentType = "application/json"
        response.writer.write("{\"token\": \"$token\"}") // JSON 응답
    }
}