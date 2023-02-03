package com.pulsar.countrieslistmulti.data.network.repositories


import com.pulsar.countrieslistmulti.data.models.CountryListDTO
import com.pulsar.countrieslistmulti.data.models.toDomain
import com.pulsar.countrieslistmulti.data.network.Constants
import com.pulsar.countrieslistmulti.domain.repositories.CountriesRepository
import com.pulsar.countrieslistmulti.domain.models.Country
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class CountriesRepositoryImpl(private val ktorClient: HttpClient) : CountriesRepository {
    override suspend fun fetchAllCountries(): List<Country> {
        //val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
        //ktorClient.get(Constants.ALL_COUNTRIES).content.toString()
        val actual: MutableList<CountryListDTO.CountryDTO> = ktorClient.get(Constants.ALL_COUNTRIES).body()
        return actual.toDomain()
    }
}