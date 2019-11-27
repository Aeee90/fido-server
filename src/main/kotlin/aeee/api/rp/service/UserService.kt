package aeee.api.rp.service

import aeee.api.rp.dto.WebAuthnUserDetails
import aeee.api.rp.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun loadUserByUsername(userName: String): WebAuthnUserDetails = userRepository.loadUserByUsername(userName)
}