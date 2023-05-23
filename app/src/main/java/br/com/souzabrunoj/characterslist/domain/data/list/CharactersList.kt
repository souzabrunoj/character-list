package br.com.souzabrunoj.characterslist.domain.data.list

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CharactersList(
    val count: Int,
    val totalPages: Int,
    val results: List<CharactersListResult>
)

@Entity(tableName = "character")
data class CharactersListResult(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val name: String,
    val status: String,
)