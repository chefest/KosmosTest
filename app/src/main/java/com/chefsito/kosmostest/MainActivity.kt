package com.chefsito.kosmostest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chefsito.kosmostest.ui.character.viewmodel.CharacterViewModel
import com.chefsito.kosmostest.ui.composables.Character
import com.chefsito.kosmostest.ui.theme.KosmosTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewmodel: CharacterViewModel by viewModels()
        viewmodel.getCharacterList()
        setContent {
            KosmosTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val data = viewmodel.dataState.collectAsState()
                    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                        items(data.value) {
                            Character(
                                picture =  it.image,
                                name = it.name,
                                status = it.status,
                                species = it.species,
                                type = it.type,
                                gender = it.gender,
                                origin = it.origin,
                                location = it.location
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KosmosTestTheme {
        Greeting("Android")
    }
}