package aeee.api.rp.service

import aeee.api.rp.config.PublicKeyCredentialCreationConfig
import aeee.api.rp.dto.AuthenticatorPKCCOResponse
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
class AuthentcationService(
    private val publicKeyCredentialCreationConfig: PublicKeyCredentialCreationConfig
    , private val publicKeyCredentialCreationOptionUtil: PublicKeyCredentialCreationOptionUtil
){

    fun getPublickeyCredentailCreationOption(rpId: String, userName: String, userVerificationRequirement: UserVerificationRequirement): AuthenticatorPKCCOResponse{
        val challenge = publicKeyCredentialCreationOptionUtil.getChallenge(userVerificationRequirement)

        val credentials = listOf<Authenticator>( AuthenticatorImpl(null, null, 0) ).map {
            PublicKeyCredentialDescriptor(PublicKeyCredentialType.PUBLIC_KEY, it.attestedCredentialData.credentialId, null)
        }

        return AuthenticatorPKCCOResponse(
            Base64UrlUtil.encodeToString(challenge.value)
            , publicKeyCredentialCreationConfig.authenticationTimeout
            , rpId
            , credentials
            , userVerificationRequirement
            , publicKeyCredentialCreationConfig.authenticationExtensions
        )
    }




}