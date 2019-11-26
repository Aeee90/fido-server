package aeee.api.rp.service

import aeee.api.rp.dto.PublicKeyCredentialCreationOptionResponse
import aeee.api.rp.util.PublicKeyCredentialCreationOptionUtil
import com.webauthn4j.authenticator.Authenticator
import com.webauthn4j.authenticator.AuthenticatorImpl
import com.webauthn4j.data.PublicKeyCredentialDescriptor
import com.webauthn4j.data.PublicKeyCredentialType
import com.webauthn4j.data.UserVerificationRequirement
import com.webauthn4j.data.extension.client.AuthenticationExtensionClientInput
import com.webauthn4j.data.extension.client.AuthenticationExtensionsClientInputs
import com.webauthn4j.data.extension.client.RegistrationExtensionClientInput
import com.webauthn4j.util.Base64UrlUtil
import org.springframework.stereotype.Service

@Service
class PublicKeyCredentialCreationOptionService(
    private val publicKeyCredentialCreationOptionUtil: PublicKeyCredentialCreationOptionUtil
){

    companion object {
        val ASSERTION_TIMEOUT = 6000L
    }

    private val registrationExtensions = AuthenticationExtensionsClientInputs<RegistrationExtensionClientInput<*>>()
    private val authenticationExtensions = AuthenticationExtensionsClientInputs<AuthenticationExtensionClientInput<*>>()

    fun getPublickeyCredentailCreationOption(userName: String, userVerificationRequirement: UserVerificationRequirement, rpId: String): PublicKeyCredentialCreationOptionResponse{
        val challenge = publicKeyCredentialCreationOptionUtil.getChallenge(userVerificationRequirement)

        val credentials = listOf<Authenticator>( AuthenticatorImpl(null, null, 0) ).map {
            PublicKeyCredentialDescriptor(PublicKeyCredentialType.PUBLIC_KEY, it.attestedCredentialData.credentialId, null)
        }

        return PublicKeyCredentialCreationOptionResponse(
            Base64UrlUtil.encodeToString(challenge.value)
            , ASSERTION_TIMEOUT
            , rpId
            , credentials
            , userVerificationRequirement
            , registrationExtensions
        )
    }


}