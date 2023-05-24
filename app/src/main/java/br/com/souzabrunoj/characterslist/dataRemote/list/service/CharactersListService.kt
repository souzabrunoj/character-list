package br.com.souzabrunoj.characterslist.dataRemote.list.service

import br.com.souzabrunoj.characterslist.dataRemote.list.response.CharactersListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersListService {

    @GET("character/")
    suspend fun getCharacterList(
        @Query("page") page: Int, @Query("name") name: String, @Query("status") status: String
    ): CharactersListResponse
}