package aeee.api.rp.dto

import com.webauthn4j.authenticator.Authenticator
import java.io.Serializable

data class WebAuthnUserDetails(
    val userName: String
    , val userHandle: ByteArray
    , val authenticators: List<Authenticator>
    , var singleFactorAuthenticationAllowed: Boolean = false
): Serializable