package br.com.souzabrunoj.characterslist.dataLocal

import android.annotation.SuppressLint
import androidx.room.Entity
import androidx.room.PrimaryKey

@SuppressLint("all")
@Entity(tableName = "character")
data class CharactersListResultLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val name: String,
)