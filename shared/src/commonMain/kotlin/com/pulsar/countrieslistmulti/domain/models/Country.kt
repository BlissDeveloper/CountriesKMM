package com.pulsar.countrieslistmulti.domain.models

import com.pulsar.countrieslistmulti.getNativeUUID

data class Country(
    val name: String? = null,
    val flag: String? = null,
    val id: String = getNativeUUID()
)
