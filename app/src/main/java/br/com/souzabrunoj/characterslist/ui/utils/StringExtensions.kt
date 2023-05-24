package br.com.souzabrunoj.characterslist.ui.utils

fun String.capitalize(): String {
    return split(' ')
        .joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }
}