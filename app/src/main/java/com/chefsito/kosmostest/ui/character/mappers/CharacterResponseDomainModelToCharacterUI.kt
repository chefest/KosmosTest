package com.chefsito.kosmostest.ui.character.mappers

import com.chefsito.kosmostest.domain.character.models.Result
import com.chefsito.kosmostest.ui.character.models.CharacterModel

fun Result.mapToCharacterModelUI(): CharacterModel {
    return CharacterModel(
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.origin.name,
        location = this.location.name,
        image = this.image,
    )
}