package aeee.api.rp.web.controller

import aeee.api.rp.dto.RegistrationPKCCOResponse
import aeee.api.rp.service.RegistrationService
import com.webauthn4j.data.UserVerificationRequirement
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/webauth")
class WebAuthController(
    private val registrationService: RegistrationService
) {

    @GetMapping("/credential/{user-name}")
    fun makeCredential(
        request: ServerHttpRequest
        , @PathVariable("user-name") userName: String
//        , @RequestParam("attType") attType: String
//        , @RequestParam("authType") authType: String
//        , @RequestParam("userVerification") userVerification: UserVerificationRequirement
//        , @RequestParam("residentKeyRequirement") residentKeyRequirement: Boolean
//        , @RequestParam("txAuthExtension") txAuthExtension: String
    ): RegistrationPKCCOResponse {
        return registrationService.getPublicKeyCredentailCreationOption(request.uri.host, userName, UserVerificationRequirement.REQUIRED)
    }


}