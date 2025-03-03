package team.react.school_chat.global.utils


data class OAuthAttributes(
    val attributes: MutableMap<String, Any>,
    val nameAttributeKey: String,
    val name: String,
    val email: String,
    val picture: String,
) {
    companion object {
        /**
         * @param registrationId OAuth 서비스명(ex: google, kakao, naver...) 후의 다른 OAuth의 확장을 고려하여 사용은 하지 않지만 인자를 받음
         * @param userAttributeName
         * @param attributes OAuth 성공시 제공 받는 데이터들
         */
        fun of(registrationId: String, userAttributeName: String, attributes: MutableMap<String, Any>): OAuthAttributes {
            return ofGoogle(userAttributeName, attributes)
        }

        private fun ofGoogle(userNameAttributeName: String, attributes: MutableMap<String, Any>): OAuthAttributes {
            return OAuthAttributes(
                name = attributes["name"] as String,
                email = attributes["email"] as String,
                picture = attributes["picture"] as String,
                attributes = attributes,
                nameAttributeKey = userNameAttributeName,
            )
        }
    }
}
