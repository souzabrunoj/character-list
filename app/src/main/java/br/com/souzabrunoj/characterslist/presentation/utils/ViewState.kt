package br.com.souzabrunoj.characterslist.presentation.utils

import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.SUCCESS
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.ERROR
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.LOADING
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.NEUTRAL


data class ViewState<D>(val status: Status, val data: D? = null, val throwable: Throwable? = null) {

    companion object {

        fun <T> success(data: T? = null) = ViewState(status = SUCCESS, data = data)

        fun <T> error(throwable: Throwable) = ViewState<T>(status = ERROR, throwable = throwable)

        fun <T> loading() = ViewState<T>(status = LOADING)

        fun <T> initializing() = ViewState<T>(status = NEUTRAL)
    }

    enum class Status { SUCCESS, ERROR, LOADING, NEUTRAL }

}