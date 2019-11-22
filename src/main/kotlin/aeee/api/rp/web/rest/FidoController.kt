package aeee.api.rp.web.rest

import aeee.api.rp.util.RandomString
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FidoController {

    @GetMapping("/random/string")
    fun randomString() = RandomString.getRandomString(10)

    fun createPublicKeyCredentialCreationOptions(){

    }

}