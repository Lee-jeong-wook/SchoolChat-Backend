package team.react.school_chat.chat.config

import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class WebSocketHandler :TextWebSocketHandler(){
    override fun afterConnectionEstablished(session: WebSocketSession) {
        println(session.id)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(message.payload)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: org.springframework.web.socket.CloseStatus) {
        println(session.id)
    }
}