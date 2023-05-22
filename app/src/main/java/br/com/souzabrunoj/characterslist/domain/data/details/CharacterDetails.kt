package br.com.souzabrunoj.characterslist.domain.data.details

data class CharacterDetails(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterDetailsLocationDetails,
    val name: String,
    val origin: CharacterDetailsOriginDetails,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterDetailsLocationDetails(
    val name: String,
    val url: String
)

data class CharacterDetailsOriginDetails(
    val name: String,
    val url: String
)