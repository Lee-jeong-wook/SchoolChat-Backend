package team.react.school_chat.auth.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.react.school_chat.auth.dto.MemberDTO
import team.react.school_chat.auth.dto.MemberUpdateRequest
import team.react.school_chat.auth.repository.MemberRepository
import team.react.school_chat.global.exception.CustomException
import team.react.school_chat.global.exception.ErrorCode

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun joinMember(member: MemberDTO) = member.email.takeIf {
            !this.memberRepository.existsById(it)
        }
        ?.let {
            memberRepository.save(member.toEntity())
        }
        ?: throw CustomException(ErrorCode.ALREADY_EXIST, "이미 존재하는 계정입니다.")

    fun findByEmail(email: String) = this.memberRepository.findByIdOrNull(email)
        ?: throw CustomException(ErrorCode.NOT_FOUND, "존재하지 않는 계정 이메일 입니다.")

    @Transactional
    fun updateMember(email: String, member: MemberUpdateRequest, validEmail: String) =
        validEmail.takeIf {
            it == email
        }
            ?.let {
                this.memberRepository.findByIdOrNull(email)
                    ?.apply {
                        name = member.name
                        picture = member.picture
                    }
                    ?: throw CustomException(ErrorCode.NOT_FOUND, "존재하지 않는 계정 이메일 입니다.")
            }
            ?: throw CustomException(ErrorCode.UNAUTHORIZED, "다른 사람의 계정을 바꿀 수 없습니다.")
}