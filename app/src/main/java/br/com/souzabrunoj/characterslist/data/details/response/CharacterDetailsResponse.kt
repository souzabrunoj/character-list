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
    val location: LocationDetailsResponse,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: OriginDetailsResponse,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

data class LocationDetailsResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

data class OriginDetailsResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)