package team.react.school_chat.domain.social.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import team.react.school_chat.domain.social.dto.RemoveFriendRequest
import team.react.school_chat.domain.social.service.SocialService

@RestController
@RequestMapping("/social")
class SocialController(val socialService: SocialService) {
    @PostMapping("")
    fun addFriends(@RequestBody friendEmails: List<String>, authentication: Authentication): ResponseEntity<Unit> {
        val ownerEmail = authentication.principal.toString()

        this.socialService.addFriends(ownerEmail, friendEmails)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @DeleteMapping("")
    fun removeFriend(@RequestBody body: RemoveFriendRequest, authentication: Authentication): ResponseEntity<Unit> {
        val ownerEmail = authentication.principal.toString()

        this.socialService.removeFriend(ownerEmail, body.friendEmail)

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}