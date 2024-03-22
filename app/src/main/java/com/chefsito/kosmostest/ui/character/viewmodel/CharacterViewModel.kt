package com.chefsito.kosmostest.ui.character.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chefsito.kosmostest.domain.character.models.CharacterResponseDomainModel
import com.chefsito.kosmostest.domain.character.usecases.GetCharactersUseCase
import com.chefsito.kosmostest.ui.character.mappers.mapToCharacterModelUI
import com.chefsito.kosmostest.ui.character.models.CharacterModel
import com.chefsito.kosmostest.ui.character.views.CharacterScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {
    private val _state: MutableStateFlow<CharacterScreenViewState?> = MutableStateFlow(null)
    val state: StateFlow<CharacterScreenViewState?> = _state.asStateFlow()
    private val _dataState: MutableStateFlow<List<CharacterModel>> = MutableStateFlow(listOf())
    val dataState: StateFlow<List<CharacterModel>> = _dataState.asStateFlow()


    fun getCharacterList(){
        _state.update { CharacterScreenViewState.Init }
        viewModelScope.launch {
            getCharactersUseCase.execute("1").onSuccess {
                val uiModel = it.results.map { it.mapToCharacterModelUI() }
                _dataState.update { uiModel }
            }.onFailure {
                _state.update { CharacterScreenViewState.Error("Algo salio mal") }
            }
        }
    }

}