package br.com.souzabrunoj.characterslist.data.list.service

import br.com.souzabrunoj.characterslist.data.list.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersListService {

    @GET("character/")
    suspend fun getCharacterList(@Query("page") page: Int): CharactersResponse
}