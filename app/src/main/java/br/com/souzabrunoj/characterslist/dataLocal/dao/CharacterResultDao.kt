package br.com.souzabrunoj.characterslist.dataLocal.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult

@Dao
interface CharacterResultDao {

    @Query("SELECT * FROM character")
    fun getCharacters(): PagingSource<Int, CharactersListResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(characters: List<CharactersListResult>)

    @Query("DELETE FROM character")
    suspend fun deleteCharacters()
}