package br.com.souzabrunoj.characterslist.data.details.service

import br.com.souzabrunoj.characterslist.data.details.response.CharacterDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface CharacterDetailsService {

    @GET("character/{characterId}")
    suspend fun getCharacterDetails(@Path("characterId") id: String): CharacterDetailsResponse
}