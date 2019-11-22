package aeee.api.rp.web.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Hello {

    @GetMapping("hello")
    fun hello() = "Hello, FIDO"

}