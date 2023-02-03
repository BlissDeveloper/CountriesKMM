package com.pulsar.countrieslistmulti.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.pulsar.countrieslistmulti.Greeting
import com.pulsar.countrieslistmulti.android.presentation.MainActivityViewModel
import com.pulsar.countrieslistmulti.domain.models.Country
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CountryList()
                }
            }
        }
    }
}

@Composable
fun CountryList(viewModel: MainActivityViewModel = koinViewModel()) {
    val mainUiState = viewModel.mainActivityUiState
    if (mainUiState.value.isLoading) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn() {
            items(items = mainUiState.value.countriesList, key = {
                return@items it.id
            }) { country ->
                CountryItem(country = country)
            }
        }
    }
}

@Composable
fun CountryItem(country: Country) {
    Row() {
        if (country.flag.isNullOrEmpty()) {
            return
        }
        AsyncImage(model = country.flag, contentDescription = "")
        if (country.name.isNullOrEmpty()) {
            return
        }
        Text(text = country.name!!)
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CountryList()
    }
}
