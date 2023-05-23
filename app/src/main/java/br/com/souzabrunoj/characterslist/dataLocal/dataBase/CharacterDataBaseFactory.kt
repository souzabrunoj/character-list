package br.com.souzabrunoj.characterslist.dataLocal.dataBase

import android.content.Context
import androidx.room.Room

private const val CHARACTER_DATA_BASE = "characterDB"

class CharacterDataBaseFactory(private val context: Context) {

    val dataBase = provideDataBase()

    private fun provideDataBase(): CharacterListDataBase{
        return Room.databaseBuilder(context, CharacterListDataBase::class.java, CHARACTER_DATA_BASE).build()
    }
}