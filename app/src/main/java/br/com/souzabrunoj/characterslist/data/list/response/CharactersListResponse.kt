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
    @SerializedName("created")
    val created: String?,
    @SerializedName("episode")
    val episode: List<String>?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("location")
    val location: CharactersListLocationResponse?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin")
    val origin: CharactersListOriginResponse?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

data class CharactersListLocationResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)

data class CharactersListOriginResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)
