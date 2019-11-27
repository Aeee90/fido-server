package aeee.api.rp.dto

import com.webauthn4j.data.PublicKeyCredentialDescriptor
import com.webauthn4j.data.PublicKeyCredentialParameters
import com.webauthn4j.data.PublicKeyCredentialRpEntity
import com.webauthn4j.data.client.challenge.Challenge
import com.webauthn4j.data.extension.client.AuthenticationExtensionsClientInputs
import java.io.Serializable

data class RegistrationPKCCOResponse(
        val relyingParty: PublicKeyCredentialRpEntity
        , val userName: String
        , val challenge: Challenge
        , val pubKeyCredParams: List<PublicKeyCredentialParameters>
        , val registrationTimeout: Long
//        , private val authenticationTimeout: Long
        , val credentials: List<PublicKeyCredentialDescriptor>
        , val registrationExtensions: AuthenticationExtensionsClientInputs<*>
//        , private val authenticationExtensions: AuthenticationExtensionsClientInputs<*>
//        , private val parameters: Parameters
): Serializable