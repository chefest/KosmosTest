package com.chefsito.kosmostest.di

import com.chefsito.kosmostest.domain.character.repository.CharacterRepository
import com.chefsito.kosmostest.domain.character.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun providesCharacterUseCase(
        characterRepository: CharacterRepository,
        coroutineDispatcher: CoroutineDispatcher
    ): GetCharactersUseCase =
        GetCharactersUseCase(characterRepository, coroutineDispatcher)
}