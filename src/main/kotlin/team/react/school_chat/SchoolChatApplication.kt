package team.react.school_chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class SchoolChatApplication

fun main(args: Array<String>) {
    runApplication<SchoolChatApplication>(*args)
}
