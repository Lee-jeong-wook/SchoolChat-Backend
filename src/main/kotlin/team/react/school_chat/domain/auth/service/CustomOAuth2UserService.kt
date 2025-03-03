package team.react.school_chat.domain.auth.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import team.react.school_chat.domain.auth.domain.Member
import team.react.school_chat.domain.auth.repository.MemberRepository
import team.react.school_chat.global.utils.JwtProvider
import team.react.school_chat.global.utils.OAuthAttributes
import java.util.*

@Service
class CustomOAuth2UserService(
    private val jwtProvider: JwtProvider,
    private val memberRepository: MemberRepository
): OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val delegate = DefaultOAuth2UserService()
        val oAuth2User = delegate.loadUser(userRequest)

        val registrationId = userRequest
            .clientRegistration
            .registrationId

        val userNameAttributeName = userRequest
            .clientRegistration
            .providerDetails
            .userInfoEndpoint
            .userNameAttributeName

        val attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.attributes)
            .apply {
                attributes.toMutableMap().apply {
                    put("token", jwtProvider.generateToken(email))
                }
            }
        val email = attributes.attributes["email"].toString()

        this.memberRepository.findByIdOrNull(email)
            ?:run {
                val member = Member(
                    attributes.attributes["email"].toString(),
                    attributes.attributes["name"].toString(),
                    attributes.attributes["picture"].toString()
                )
                this.memberRepository.save(member)
            }

        return DefaultOAuth2User(
            Collections.singleton(SimpleGrantedAuthority("ROLE_USER")),
            attributes.attributes,
            attributes.nameAttributeKey
        )
    }
}