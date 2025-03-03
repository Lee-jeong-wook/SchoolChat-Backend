package team.react.school_chat.domain.member.domain

import jakarta.persistence.*

@Entity
@Table(name = "friend")
data class Friend(
    @EmbeddedId
    val id: FriendId,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerEmail")
    @JoinColumn(name = "owner_email", nullable = false)
    var owner: Member,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("friendEmail")
    @JoinColumn(name = "friend_email", nullable = false)
    var friend: Member,
)
