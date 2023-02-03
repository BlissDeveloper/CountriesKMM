package com.pulsar.countrieslistmulti.android.presentation

import com.pulsar.countrieslistmulti.domain.models.Country


data class MainActivityUiState(
    val isLoading: Boolean = false,
    val countriesList: List<Country> = listOf()
)
