package team.react.school_chat.domain.chat.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import team.react.school_chat.domain.chat.domain.ChatRoom
import team.react.school_chat.domain.chat.repository.ChatRoomRepository
import team.react.school_chat.global.exception.CustomException
import team.react.school_chat.global.exception.ErrorCode

@Service
class ChatRoomService (private val chatRoomRepository: ChatRoomRepository){
//    fun findChatRoom(chatRoomId: Long, memberId: String): ChatRoom {
//        if(!checkMember(chatRoomId, memberId)){
//            throw CustomException(ErrorCode.FORBIDDEN, "이 채팅방의 멤버가 아닙니다.")
//        }
//        return chatRoomRepository.findByIdOrNull(chatRoomId)?:
//        throw CustomException(ErrorCode.NOT_FOUND, "존재하지 않는 채팅방입니다.");
//    }
////    fun findAllChatRoom(memberId: String): List<ChatRoom>{
////        chatRoomRepository.findAllById(memberId);
////    }
//    /**
//     * 개발중
//     */
//    fun checkMember(memberId: String, chatRoomId: String): Boolean{
//        return false
//    }

}