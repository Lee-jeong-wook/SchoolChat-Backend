package team.react.school_chat.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.context.SecurityContextPersistenceFilter
import team.react.school_chat.global.utils.JwtAuthenticationFilter
import team.react.school_chat.global.utils.OAuth2LoginSuccessHandler

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val oAuth2LoginSuccessHandler: OAuth2LoginSuccessHandler
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf {
                it.disable()
            }
            .authorizeHttpRequests { it
                .requestMatchers("/api/user/email").authenticated()
                .anyRequest().permitAll()
            }
            .oauth2Login {
                it.successHandler(oAuth2LoginSuccessHandler)
            }
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}