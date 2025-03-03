package team.react.school_chat.domain.member.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import team.react.school_chat.domain.member.dto.MemberDTO
import team.react.school_chat.domain.member.dto.MemberUpdateRequest
import team.react.school_chat.domain.member.service.MemberService

@RestController
@RequestMapping("/member")
class MemberController(val memberService: MemberService) {
    @PostMapping("")
    fun joinMember(@RequestBody member: MemberDTO) = this.memberService.joinMember(member)

    @GetMapping("/{email}")
    fun findByEmail(@PathVariable email: String) = this.memberService.findByEmail(email)

    @GetMapping("/my")
    fun findMy(authentication: Authentication): MemberDTO {
        val email = authentication.principal.toString()

        return this.memberService.findByEmail(email)
    }

    @PatchMapping("/{email}")
    fun updateMember(@PathVariable email: String, @RequestBody member: MemberUpdateRequest, authentication: Authentication): MemberDTO {
        val validEmail = authentication.principal.toString()

        return this.memberService.updateMember(email, member, validEmail)
    }
}