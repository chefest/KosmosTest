package com.chefsito.kosmostest.data.character.datasource

import com.chefsito.kosmostest.data.character.models.CharacterResponseDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET(GET_CHARACTER_LIST)
    suspend fun getCharacterList(@Query("page") page: String = "1"): Response<CharacterResponseDataModel>

    companion object {
        private const val GET_CHARACTER_LIST = "api/character/"
    }
}