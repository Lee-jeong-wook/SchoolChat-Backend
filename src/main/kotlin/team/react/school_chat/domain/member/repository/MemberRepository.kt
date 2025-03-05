package team.react.school_chat.domain.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import team.react.school_chat.domain.member.domain.Member

@Repository
interface MemberRepository: JpaRepository<Member, String> {
    @Query("""
        SELECT CASE WHEN COUNT(m) = 2 THEN TRUE ELSE FALSE END
        FROM Member m WHERE m.email IN (:ownerEmail, :friendEmail)
    """)
    fun existsBothMemberById(ownerEmail: String, friendEmail: String): Boolean
}