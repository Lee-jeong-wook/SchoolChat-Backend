package team.react.school_chat.auth.repository

import org.springframework.data.jpa.repository.JpaRepository
import team.react.school_chat.auth.domain.Member

interface MemberRepository: JpaRepository<Member, String> {
}