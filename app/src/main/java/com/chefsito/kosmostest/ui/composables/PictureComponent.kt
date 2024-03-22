package com.chefsito.kosmostest.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.chefsito.kosmostest.R

@Composable
fun PictureComponent(
    modifier: Modifier = Modifier,
    url: String = "",
    placeholder: Int = R.drawable.image_loading,
    contentDescription: String = ""
) {
    AsyncImage(
        model = url,
        contentDescription = contentDescription,
        placeholder = painterResource(id = placeholder)
    )
}