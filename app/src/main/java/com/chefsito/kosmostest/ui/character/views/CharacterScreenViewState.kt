package com.chefsito.kosmostest.ui.character.views

sealed class CharacterScreenViewState {
    object Init : CharacterScreenViewState()
    object Loading : CharacterScreenViewState()
    object Success : CharacterScreenViewState()
    data class Error(val message: String) : CharacterScreenViewState()
}