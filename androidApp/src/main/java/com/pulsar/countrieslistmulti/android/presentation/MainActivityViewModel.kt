package com.pulsar.countrieslistmulti.android.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pulsar.countrieslistmulti.android.di.viewModelModule
import com.pulsar.countrieslistmulti.domain.use_cases.FetchAllCountriesUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(private val fetchAllCountriesUseCase: FetchAllCountriesUseCase) :
    ViewModel() {
    val mainActivityUiState = mutableStateOf(MainActivityUiState())

    init {
        fetchAllCountries()
    }

    private fun fetchAllCountries() {
        mainActivityUiState.value = mainActivityUiState.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            val list = fetchAllCountriesUseCase.execute()
            mainActivityUiState.value = mainActivityUiState.value.copy(
                countriesList = list,
                isLoading = false
            )
        }
    }
}