package br.com.souzabrunoj.characterslist.dataLocal.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.souzabrunoj.characterslist.dataLocal.CharacterRemoteKeysLocal
import br.com.souzabrunoj.characterslist.dataLocal.dao.CharacterResultDao
import br.com.souzabrunoj.characterslist.dataLocal.dao.CharactersRemoteKeysDao
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult

@Database(entities = [CharactersListResult::class, CharacterRemoteKeysLocal::class], version = 1, exportSchema = false)
abstract class CharacterListDataBase : RoomDatabase() {

    abstract fun charactersDao(): CharacterResultDao
    abstract fun charactersRemoteKeysDao(): CharactersRemoteKeysDao

}