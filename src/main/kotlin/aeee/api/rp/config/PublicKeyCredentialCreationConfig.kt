package aeee.api.rp.config

import com.webauthn4j.data.PublicKeyCredentialParameters
import com.webauthn4j.data.PublicKeyCredentialRpEntity
import com.webauthn4j.data.extension.client.AuthenticationExtensionClientInput
import com.webauthn4j.data.extension.client.AuthenticationExtensionsClientInputs
import com.webauthn4j.data.extension.client.RegistrationExtensionClientInput
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer

@Configuration
class PublicKeyCredentialCreationConfig {

    var pubKeyCredParams: List<PublicKeyCredentialParameters> = emptyList()
    var registrationTimeout: Long = 60000L
    var authenticationTimeout: Long = 60000L
    var rpId: String = ""
    var rpName: String = ""
    var rpIcon: String = ""
    var registrationExtensions = AuthenticationExtensionsClientInputs<RegistrationExtensionClientInput<*>>()
    var authenticationExtensions = AuthenticationExtensionsClientInputs<AuthenticationExtensionClientInput<*>>()

    fun publicKeyCredentialRpEntity(rpId: String = this.rpId) = PublicKeyCredentialRpEntity(rpId, rpName, rpIcon)
}