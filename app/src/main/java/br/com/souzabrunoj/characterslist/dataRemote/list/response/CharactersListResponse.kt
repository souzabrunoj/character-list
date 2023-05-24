package br.com.souzabrunoj.characterslist.dataRemote.list.response

import com.google.gson.annotations.SerializedName

data class CharactersListResponse(
    @SerializedName("info")
    val info: CharactersListInfoResponse?,
    @SerializedName("results")
    val results: List<CharactersListResultResponse>?
)

data class CharactersListInfoResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("pages")
    val totalPages: Int?,
)

data class CharactersListResultResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("status")
    val status: String?,
)

