package br.com.souzabrunoj.characterslist.data.list.response

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info")
    val info: CharacterInfoResponse,
    @SerializedName("results")
    val results: List<CharacterResultResponse>
)

data class CharacterInfoResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: String
)

data class CharacterResultResponse(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: CharacterLocationResponse,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: CharacterOriginResponse,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

data class CharacterLocationResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class CharacterOriginResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
