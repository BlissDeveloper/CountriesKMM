package com.pulsar.countrieslistmulti.data.models

import com.pulsar.countrieslistmulti.domain.models.Country

@kotlinx.serialization.Serializable
data class CountryListDTO(val data: MutableList<CountryDTO>? = null) {
    @kotlinx.serialization.Serializable
    data class CountryDTO(
        val flags: Flags? = null,
        val name: Name? = null,
        val population: Int? = null, // 84339067
    ) {
        @kotlinx.serialization.Serializable
        data class Flags(
            val alt: String? = null, // The flag of Turkey has a red field bearing a large fly-side facing white crescent and a smaller five-pointed white star placed just outside the crescent opening. The white crescent and star are offset slightly towards the hoist side of center.
            val png: String? = null, // https://flagcdn.com/w320/tr.png
            val svg: String? = null // https://flagcdn.com/tr.svg
        )

        @kotlinx.serialization.Serializable
        data class Name(
            val common: String? = null, // Turkey
            val official: String? = null // Republic of Turkey
        )
    }



}

fun CountryListDTO.CountryDTO.toDomain() = Country(
    name = name?.official,
    flag = flags?.png
)

fun Collection<CountryListDTO.CountryDTO>.toDomain() = this.map { it.toDomain() }.toMutableList()