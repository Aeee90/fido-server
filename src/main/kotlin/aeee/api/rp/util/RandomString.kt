package aeee.api.rp.util

import kotlin.random.Random

object RandomString {
    fun getRandomString(size: Int) = Array(size) { Random.nextInt(65, 91).toChar() }.joinToString("")
}