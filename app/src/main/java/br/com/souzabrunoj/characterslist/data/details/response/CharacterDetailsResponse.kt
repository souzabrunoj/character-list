package br.com.souzabrunoj.characterslist.data.details.response

import com.google.gson.annotations.SerializedName

data class CharacterDetailsResponse(
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
    val location: LocationResponse,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: OriginResponse,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

data class LocationResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class OriginResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)