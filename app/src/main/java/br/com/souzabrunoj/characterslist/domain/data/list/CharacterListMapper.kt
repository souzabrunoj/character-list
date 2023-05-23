package br.com.souzabrunoj.characterslist.domain.data.list

import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResponse
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResultResponse
import br.com.souzabrunoj.characterslist.domain.utlis.ZERO

fun CharactersListResponse.toDomain() = CharactersList(
    count = this.info?.count ?: ZERO,
    totalPages = this.info?.totalPages ?: ZERO,
    results = results?.map { it.toDomain() } ?: listOf()
)

fun CharactersListResultResponse?.toDomain() = CharactersListResult(
    id = this?.id ?: ZERO,
    image = this?.image.orEmpty(),
    name = this?.name.orEmpty(),
    status = this?.status.orEmpty()
)
