package team.react.school_chat.domain.member.domain

import jakarta.persistence.*
import team.react.school_chat.domain.social.domain.Friend

@Entity
@Table(name = "member")
data class Member(
    @Id
    @Column(name = "email", nullable = false)
    var email: String,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "picture", nullable = false)
    var picture: String,

    @OneToMany(mappedBy = "owner", cascade= [(CascadeType.ALL)], orphanRemoval= true)
    var friends: MutableList<Friend> = mutableListOf(),

    )
