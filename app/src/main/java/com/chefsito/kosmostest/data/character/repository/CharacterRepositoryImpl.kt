package com.chefsito.kosmostest.data.character.repository

import com.chefsito.kosmostest.data.character.datasource.CharacterApi
import com.chefsito.kosmostest.data.mappers.mapToCharacterResponseDomainModel
import com.chefsito.kosmostest.domain.character.models.CharacterResponseDomainModel
import com.chefsito.kosmostest.domain.character.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterAPI: CharacterApi
) : CharacterRepository {
    override suspend fun execGetCharacters(page: String): CharacterResponseDomainModel {
        val response = characterAPI.getCharacterList(page = page)
        if (response.isSuccessful) {
            response.body()?.let {
                return it.mapToCharacterResponseDomainModel()
            }
        } else when (response.code()){
            400-> throw Exception("Error code 400")
            500-> throw Exception("Error code 500")
        }
        throw UnknownError("Error desconocido")
    }
}