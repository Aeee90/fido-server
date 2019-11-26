package aeee.api.rp.web.controller

import org.springframework.http.HttpRequest
import org.springframework.http.server.ServerHttpRequest
import org.springframework.web.HttpRequestHandler
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/webauth")
class WebAuthController {


    @GetMapping("/credential/{user-name}")
    fun makeCredential(
        request: HttpRequest
        , @PathVariable("user-name") userName: String
        , @RequestParam("attType") attType: String
        , @RequestParam("authType") authType: String
        , @RequestParam("userVerification") userVerification: String
        , @RequestParam("residentKeyRequirement") residentKeyRequirement: Boolean
        , @RequestParam("txAuthExtension") txAuthExtension: String
    ){
    }

    @GetMapping("/test")
    fun test(request: ServerHttpRequest) {
        println(request.uri)
    }

}