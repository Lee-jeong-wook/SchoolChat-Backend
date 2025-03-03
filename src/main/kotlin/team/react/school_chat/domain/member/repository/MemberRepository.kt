package team.react.school_chat.domain.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.domain.member.domain.Member

interface MemberRepository: JpaRepository<Member, String> {
}