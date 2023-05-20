package br.com.souzabrunoj.characterslist.data.list.service

import br.com.souzabrunoj.characterslist.data.list.response.CharactersResponse
import retrofit2.http.GET

interface CharactersListService {

    @GET("character")
    suspend fun getCharacterList(): CharactersResponse
}