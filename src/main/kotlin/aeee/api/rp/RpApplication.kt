package aeee.api.rp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin

@SpringBootApplication
@CrossOrigin(origins = ["http://localhost:4001"])
class RpApplication

fun main(args: Array<String>) {
	runApplication<RpApplication>(*args)
}
