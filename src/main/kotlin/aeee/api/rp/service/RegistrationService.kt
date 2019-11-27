package aeee.api.rp.service

import aeee.api.rp.config.PublicKeyCredentialCreationConfig
import aeee.api.rp.dto.RegistrationPKCCOResponse
import aeee.api.rp.util.PublicKeyCredentialCreationOptionUtil
import com.webauthn4j.data.PublicKeyCredentialDescriptor
import com.webauthn4j.data.PublicKeyCredentialType
import com.webauthn4j.data.UserVerificationRequirement
import org.springframework.stereotype.Service

@Service
class RegistrationService(
    private val publicKeyCredentialCreationConfig: PublicKeyCredentialCreationConfig
    , private val publicKeyCredentialCreationOptionUtil: PublicKeyCredentialCreationOptionUtil
    , private val userService: UserService
) {

    fun getPublickeyCredentailCreationOption(userName: String, userVerificationRequirement: UserVerificationRequirement): RegistrationPKCCOResponse{
        val relyingParty = publicKeyCredentialCreationConfig.publicKeyCredentialRpEntity
        //Session에 저장

        val challenge = publicKeyCredentialCreationOptionUtil.getChallenge(userVerificationRequirement)
        val user = userService.loadUserByUsername(userName)

        return RegistrationPKCCOResponse(
            relyingParty
            , userName
            , challenge
            , publicKeyCredentialCreationConfig.pubKeyCredParams
            , publicKeyCredentialCreationConfig.registrationTimeout
            , user.authenticators.map { PublicKeyCredentialDescriptor(PublicKeyCredentialType.PUBLIC_KEY, it.attestedCredentialData.credentialId, null) }
            , publicKeyCredentialCreationConfig.registrationExtensions
        )
    }
}