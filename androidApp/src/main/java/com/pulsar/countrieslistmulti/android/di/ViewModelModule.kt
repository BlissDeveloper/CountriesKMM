package com.pulsar.countrieslistmulti.android.di

import com.pulsar.countrieslistmulti.android.presentation.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}