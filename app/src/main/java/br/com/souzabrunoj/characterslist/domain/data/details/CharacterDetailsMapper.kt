package br.com.souzabrunoj.characterslist.domain.data.details

import br.com.souzabrunoj.characterslist.dataRemote.details.response.CharacterDetailsLocationDetailsResponse
import br.com.souzabrunoj.characterslist.dataRemote.details.response.CharacterDetailsOriginDetailsResponse
import br.com.souzabrunoj.characterslist.dataRemote.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.domain.utlis.ZERO

fun CharacterDetailsResponse?.toDomain() = CharacterDetails(
    created = this?.created.orEmpty(),
    episode = this?.episode?.map { it } ?: listOf(),
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

fun CharacterDetailsLocationDetailsResponse?.toDomain() = CharacterDetailsLocationDetails(
    name = this?.name.orEmpty(),
    url = this?.url.orEmpty()
)

fun CharacterDetailsOriginDetailsResponse?.toDomain() = CharacterDetailsOriginDetails(
    name = this?.name.orEmpty(),
    url = this?.url.orEmpty()
)