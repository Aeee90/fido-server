package aeee.api.rp.util

import com.webauthn4j.converter.util.CborConverter
import com.webauthn4j.converter.util.JsonConverter
import com.webauthn4j.data.UserVerificationRequirement
import com.webauthn4j.data.client.challenge.Challenge
import com.webauthn4j.data.client.challenge.DefaultChallenge
import org.springframework.http.server.ServerHttpRequest
import org.springframework.stereotype.Component

@Component
class PublicKeyCredentialCreationOptionUtil(
    private val jsonConverter: JsonConverter
)  {

    private val cborConverter: CborConverter = jsonConverter.cborConverter

    fun getChallenge(userVerificationRequirement: UserVerificationRequirement): Challenge {
        val envelope = UserVerificationEncodedChallengeEnvelope(userVerificationRequirement, DefaultChallenge().value)
        val bytes: ByteArray = cborConverter.writeValueAsBytes(envelope)
        return DefaultChallenge(bytes)
    }

    fun effeciveRpId(request: ServerHttpRequest) = request.uri

    data class UserVerificationEncodedChallengeEnvelope(
        var userVerification: UserVerificationRequirement
        , var challenge: ByteArray
    )
}