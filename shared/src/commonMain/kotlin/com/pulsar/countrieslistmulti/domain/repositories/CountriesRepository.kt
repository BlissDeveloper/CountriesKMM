package com.pulsar.countrieslistmulti.domain.repositories

import com.pulsar.countrieslistmulti.domain.models.Country

interface CountriesRepository {
   suspend fun fetchAllCountries(): List<Country>
}