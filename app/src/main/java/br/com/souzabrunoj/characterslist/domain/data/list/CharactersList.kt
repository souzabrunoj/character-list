package br.com.souzabrunoj.characterslist.domain.data.list

data class CharactersList(
    val info: CharactersListInfo,
    val results: List<CharactersListResult>
)

data class CharactersListInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)

data class CharactersListResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharactersListLocation,
    val name: String,
    val origin: CharactersListOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharactersListLocation(
    val name: String,
    val url: String
)

data class CharactersListOrigin(
    val name: String,
    val url: String
)
