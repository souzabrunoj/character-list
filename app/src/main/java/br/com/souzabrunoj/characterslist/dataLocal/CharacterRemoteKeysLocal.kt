package br.com.souzabrunoj.characterslist.dataLocal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterRemoteKeysLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?
)
