package com.chefsito.kosmostest.di

import com.chefsito.kosmostest.data.character.datasource.CharacterApi
import com.chefsito.kosmostest.data.character.repository.CharacterRepositoryImpl
import com.chefsito.kosmostest.domain.character.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providesCharacterRepository(
        characterAPI: CharacterApi
    ): CharacterRepository = CharacterRepositoryImpl(characterAPI)
}