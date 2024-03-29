package aeee.api.rp.dto

import com.webauthn4j.data.*
import com.webauthn4j.data.extension.client.AuthenticationExtensionsClientInputs
import java.io.Serializable

data class AuthenticatorPKCCOResponse(
    val challenge: String
    , val timeout: Long
    , val rpId: String
    , val allowCredentials: List<PublicKeyCredentialDescriptor>
    , val userVerification: UserVerificationRequirement
    , val extensions: AuthenticationExtensionsClientInputs<*>
): Serializable
