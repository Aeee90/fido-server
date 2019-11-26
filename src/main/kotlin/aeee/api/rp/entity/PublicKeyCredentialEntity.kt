package aeee.api.rp.entity

class PublicKeyCredentialEntity private constructor(private val name: String) {
    companion object {
        val DEFAULT = PublicKeyCredentialEntity("Mutecsoft Company")
    }
}