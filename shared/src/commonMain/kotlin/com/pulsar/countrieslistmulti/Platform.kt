package com.pulsar.countrieslistmulti

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform