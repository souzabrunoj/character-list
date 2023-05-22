package br.com.souzabrunoj.characterslist.domain.data.list

import br.com.souzabrunoj.characterslist.data.list.response.CharactersListInfoResponse
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListLocationResponse
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListOriginResponse
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResponse
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResultResponse
import br.com.souzabrunoj.characterslist.domain.utlis.ZERO

fun CharactersListResponse.toDomain() = CharactersList(
    info = info.toDomain(),
    results = results?.map { it.toDomain() } ?: listOf()
)

fun CharactersListInfoResponse?.toDomain() = CharactersListInfo(
    count = this?.count ?: ZERO,
    next = this?.next.orEmpty(),
    pages = this?.pages ?: ZERO,
    prev = this?.prev.orEmpty()
)

fun CharactersListResultResponse?.toDomain() = CharactersListResult(
    created = this?.created.orEmpty(),
    episode = this?.episode.orEmpty(),
    gender = this?.gender.orEmpty(),
    id = this?.id ?: ZERO,
    image = this?.image.orEmpty(),
    location = this?.location.toDomain(),
    name = this?.name.orEmpty(),
    origin = this?.origin.toDomain(),
    species = this?.species.orEmpty(),
    status = this?.status.orEmpty(),
    type = this?.type.orEmpty(),
    url = this?.url.orEmpty()
)

fun CharactersListLocationResponse?.toDomain() = CharactersListLocation(
    name = this?.name.orEmpty(),
    url = this?.url.orEmpty()
)

fun CharactersListOriginResponse?.toDomain() = CharactersListOrigin(
    name = this?.name.orEmpty(),
    url = this?.url.orEmpty()
)
