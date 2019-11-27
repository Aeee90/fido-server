package aeee.api.rp.repository

import aeee.api.rp.dto.WebAuthnUserDetails
import com.webauthn4j.authenticator.Authenticator
import com.webauthn4j.authenticator.AuthenticatorImpl
import org.springframework.stereotype.Repository
import org.springframework.util.Base64Utils
import java.util.*
import kotlin.collections.HashMap

@Repository
class UserRepository {

    private val tempDataBaseWithUserName: HashMap<String, WebAuthnUserDetails> = HashMap()

    fun loadUserByUsername(userName: String): WebAuthnUserDetails = if(tempDataBaseWithUserName.containsKey(userName)) tempDataBaseWithUserName[userName]!! else createUser(userName)

    private fun createUser(userName: String): WebAuthnUserDetails{
        val user = WebAuthnUserDetails(
                userName
                , Base64Utils.decodeFromString(userName + Date().time)
                ,  listOf()
        )
        tempDataBaseWithUserName[user.userName] = user

        return user
    }
}