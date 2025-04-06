package team.react.school_chat.domain.social.domain

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class FriendId(
    val ownerEmail: String,
    val friendEmail: String
): Serializable
