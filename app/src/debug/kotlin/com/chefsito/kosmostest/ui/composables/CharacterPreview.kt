package com.chefsito.kosmostest.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CharacterPreview() {
    Character(
        picture = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = "Earth (C-137)",
        location = "Citadel of Ricks"
    )
}