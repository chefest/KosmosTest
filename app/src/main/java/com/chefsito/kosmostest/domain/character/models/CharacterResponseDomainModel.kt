package com.chefsito.kosmostest.domain.character.models

data class CharacterResponseDomainModel(
    val info: Info,
    val results: List<Result>
)