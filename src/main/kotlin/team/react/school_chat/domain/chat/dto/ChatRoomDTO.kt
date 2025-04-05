package team.react.school_chat.domain.chat.dto

import team.react.school_chat.domain.chat.domain.ChatRoom
import team.react.school_chat.domain.member.dto.MemberDTO

data class ChatRoomMemberDTO (
    val chatRoom: ChatRoom,
    val memberList: List<String>
)