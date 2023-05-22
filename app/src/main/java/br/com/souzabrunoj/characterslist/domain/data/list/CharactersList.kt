package br.com.souzabrunoj.characterslist.domain.data.list

data class CharactersList(
    val count: Int,
    val pages: Int,
    val results: List<CharactersListResult>
)

data class CharactersListResult(
    val id: Int,
    val image: String,
    val name: String,
)
