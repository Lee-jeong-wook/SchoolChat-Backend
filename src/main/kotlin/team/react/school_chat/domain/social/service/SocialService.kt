package team.react.school_chat.domain.social.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import team.react.school_chat.domain.member.repository.MemberRepository
import team.react.school_chat.domain.social.domain.Friend
import team.react.school_chat.domain.social.domain.FriendId
import team.react.school_chat.domain.social.dto.FriendDTO
import team.react.school_chat.domain.social.repository.FriendRepository
import team.react.school_chat.global.exception.CustomException
import team.react.school_chat.global.exception.ErrorCode

@Service
class SocialService(
    private val memberRepository: MemberRepository,
    private val friendRepository: FriendRepository
) {
    fun addFriends(ownerEmail: String, friendEmails: List<String>) {
        val owner = this.memberRepository.findByIdOrNull(ownerEmail)
            ?: throw CustomException(ErrorCode.BAD_REQUEST, "사용자의 이메일이 잘못되었습니다.")

        val friends = this.memberRepository.findAllById(friendEmails)
            .takeIf { it.size == friendEmails.size }
            ?: throw CustomException(ErrorCode.BAD_REQUEST, "추가하려는 친구중 이메일의 이메일이 잘못되었습니다.")

        friends.map { friend ->
            Friend(FriendId(owner.email, friend.email), owner, friend)
        }
            .let {
                this.friendRepository.saveAll(it)
            }
    }

    fun removeFriend(ownerEmail: String, friendEmail: String) = this.friendRepository.findByIdOrNull(FriendId(ownerEmail, friendEmail))
        ?.let {
            this.friendRepository.delete(it)
        }
        ?: throw CustomException(ErrorCode.BAD_REQUEST, "사용자의 이메일이 잘못되었습니다.")
}