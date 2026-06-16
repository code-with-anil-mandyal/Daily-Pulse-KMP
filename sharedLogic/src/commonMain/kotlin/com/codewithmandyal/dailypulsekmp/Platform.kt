package com.codewithmandyal.dailypulsekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform