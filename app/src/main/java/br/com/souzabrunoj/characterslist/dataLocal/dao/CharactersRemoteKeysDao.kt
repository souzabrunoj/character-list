package br.com.souzabrunoj.characterslist.dataLocal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.souzabrunoj.characterslist.dataLocal.CharacterRemoteKeysLocal

@Dao
interface CharactersRemoteKeysDao {

    @Query("SELECT * FROM CharacterRemoteKeysLocal WHERE id =:id")
    suspend fun getRemoteKey(id: Int): CharacterRemoteKeysLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<CharacterRemoteKeysLocal>)

    @Query("DELETE FROM CharacterRemoteKeysLocal")
    suspend fun deleteAllRemoteKeys()
}