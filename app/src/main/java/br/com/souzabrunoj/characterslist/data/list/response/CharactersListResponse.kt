package br.com.souzabrunoj.characterslist.data.list.response

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
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: String?
)

data class CharactersListResultResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
)

