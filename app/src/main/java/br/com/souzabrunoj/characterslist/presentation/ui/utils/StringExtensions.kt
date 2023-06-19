package br.com.souzabrunoj.characterslist.presentation.ui.utils

fun String.capitalize(): String {
    return split(' ')
        .joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }
}