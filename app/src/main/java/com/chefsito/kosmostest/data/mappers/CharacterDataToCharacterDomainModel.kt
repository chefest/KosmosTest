package com.chefsito.kosmostest.data.mappers

import com.chefsito.kosmostest.data.character.models.CharacterResponseDataModel
import com.chefsito.kosmostest.data.character.models.Info
import com.chefsito.kosmostest.data.character.models.Location
import com.chefsito.kosmostest.data.character.models.Origin
import com.chefsito.kosmostest.data.character.models.Result
import com.chefsito.kosmostest.domain.character.models.CharacterResponseDomainModel

fun CharacterResponseDataModel.mapToCharacterResponseDomainModel(): CharacterResponseDomainModel {
    return CharacterResponseDomainModel(
        info = this.info.mapToCharacterResponseInfoDomainModel(),
        results = results.map { it.mapToCharacterResponseResultDomainModel() }
    )
}

private fun Info.mapToCharacterResponseInfoDomainModel(): com.chefsito.kosmostest.domain.character.models.Info {
    return com.chefsito.kosmostest.domain.character.models.Info(
        count = this.count,
        next = this.next,
        pages = this. pages,
        prev = this.prev
    )
}

private fun Result.mapToCharacterResponseResultDomainModel(): com.chefsito.kosmostest.domain.character.models.Result {
    return com.chefsito.kosmostest.domain.character.models.Result(
        created = this.created,
        episode = this.episode,
        gender = this.gender,
        id = this.id,
        image = this.image,
        location = this.location.mapToCharacterResponseLocationDomainModel(),
        name = this.name,
        origin = this.origin.mapToCharacterResponseOriginDomainModel(),
        species = this.species,
        status = this.status,
        type = this.type,
        url = this.url
    )
}

private fun Location.mapToCharacterResponseLocationDomainModel(): com.chefsito.kosmostest.domain.character.models.Location {
    return com.chefsito.kosmostest.domain.character.models.Location(
        name = this.name,
        url = this.url
    )
}

private fun Origin.mapToCharacterResponseOriginDomainModel(): com.chefsito.kosmostest.domain.character.models.Origin {
    return com.chefsito.kosmostest.domain.character.models.Origin(
        name = this.name,
        url = this.url
    )
}