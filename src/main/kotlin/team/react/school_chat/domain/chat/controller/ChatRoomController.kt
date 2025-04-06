package team.react.school_chat.domain.chat.controller

import org.springframework.web.bind.annotation.*
import team.react.school_chat.domain.chat.domain.Chat
import team.react.school_chat.domain.chat.domain.ChatRoom
import team.react.school_chat.domain.chat.domain.ChatRoomMember
import team.react.school_chat.domain.chat.dto.ChatRoomMemberDTO
import team.react.school_chat.domain.chat.service.ChatRoomService
import team.react.school_chat.domain.chat.service.ChatService
import team.react.school_chat.domain.member.dto.MemberDTO
import team.react.school_chat.domain.member.service.MemberService

@RestController
class ChatRoomController (private val chatRoomService: ChatRoomService, private val chatService: ChatService, private val membersService: MemberService) {
    @PostMapping("chatroom/create")
    fun createPersonalChatRoom(@RequestBody request: ChatRoomMemberDTO) {
        val chatRoom = request.chatRoom
        val memberList = request.memberList

        chatRoomService.saveChatRoom(chatRoom)  // 채팅방 저장

        val chatRoomMemberList = ArrayList<ChatRoomMember>();

        for (email in memberList) {
            val member = membersService.findByEmail(email);

            val chatRoomMember = ChatRoomMember(
                chatRoom = chatRoom,
                member = member.toEntity()
            )
            chatRoomMemberList.add(chatRoomMember)
        }

        chatRoomService.saveChatRoomMembers(chatRoomMemberList)  // 리스트를 한 번에 저장
    }
    @GetMapping("chatroom/user/{memberId}")
    fun getChatRoomByMemberId(@PathVariable memberId: String): List<ChatRoom> {
        return chatRoomService.findAllChatRoom(memberId);
    }
    @GetMapping("chatroom/room/{roomId}")
    fun getChatByChatRoomId(@PathVariable roomId: Long): List<Chat> {
        return chatService.findAllChatByChatRoomId(roomId);
    }
    @PostMapping("chatroom/addMember")
    fun addMember(@RequestBody member: ChatRoomMember) {
        chatRoomService.saveChatRoomMember(member);
    }
}