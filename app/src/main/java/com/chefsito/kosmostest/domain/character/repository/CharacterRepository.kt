package com.chefsito.kosmostest.domain.character.repository

import com.chefsito.kosmostest.domain.character.models.CharacterResponseDomainModel

interface CharacterRepository {
    suspend fun execGetCharacters(page : String): CharacterResponseDomainModel

}