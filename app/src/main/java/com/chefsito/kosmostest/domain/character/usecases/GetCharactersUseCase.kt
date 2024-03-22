package com.chefsito.kosmostest.domain.character.usecases

import com.chefsito.kosmostest.domain.character.models.CharacterResponseDomainModel
import com.chefsito.kosmostest.domain.character.repository.CharacterRepository
import com.chefsito.kosmostest.domain.common.BackgroundUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class GetCharactersUseCase(
    private val characterRepository: CharacterRepository,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): BackgroundUseCase<String, CharacterResponseDomainModel>(coroutineDispatcher) {
    override suspend fun executeInBackground(input: String?): CharacterResponseDomainModel {
        input?.let {
            with(it) {
                return characterRepository.execGetCharacters(page = input)
            }
        }?: throw NullPointerException("Input null")
    }
}