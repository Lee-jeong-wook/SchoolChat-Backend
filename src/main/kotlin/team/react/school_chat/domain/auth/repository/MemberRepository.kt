package team.react.school_chat.domain.auth.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.domain.auth.domain.Member

interface MemberRepository: JpaRepository<Member, String> {
}