package com.chefsito.kosmostest.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.chefsito.kosmostest.R


@Composable
fun Character(
    modifier: Modifier = Modifier,
    picture: String,
    name: String = "",
    status: String = "",
    species: String = "",
    type: String = "",
    gender: String = "",
    origin: String = "",
    location: String = ""
) {
    Column {


        var expanded by remember {
            mutableStateOf(false)
        }
        var buttonText by remember {
            mutableStateOf(R.string.show_details)
        }
        PictureComponent(url = picture)
        Text(text = name, color = Color.Black)
        Button(
            onClick = {
                expanded = !expanded
                buttonText = if (expanded) {
                    R.string.hide_details
                } else {
                    R.string.show_details
                }
            }
        ) {
            Text(text = stringResource(id = buttonText))
        }
        if (expanded) {
            Text(text = status, color = Color.Black)
            Text(text = species, color = Color.Black)
            Text(text = type, color = Color.Black)
            Text(text = gender, color = Color.Black)
            Text(text = origin, color = Color.Black)
            Text(text = location, color = Color.Black)
        }
    }
}