package br.com.souzabrunoj.characterslist.presentation.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.ERROR
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.LOADING
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.NEUTRAL
import br.com.souzabrunoj.characterslist.presentation.utils.ViewState.Status.SUCCESS


fun <T> createViewState() = MutableLiveData<ViewState<T>>()

fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

fun <T> LiveData<ViewState<T>>.handleWithFlow(
    lifecycleOwner: LifecycleOwner,
    onNeutral: () -> Unit,
    onLoading: () -> Unit = {},
    onFailure: (Throwable) -> Unit = {},
    onComplete: (() -> Unit) = {},
    onSuccess: (T) -> Unit
) {
    this.removeObservers(lifecycleOwner)
    observe(lifecycleOwner) { viewState ->
        when (viewState?.status) {
            LOADING -> onLoading()
            ERROR -> viewState.throwable?.let {
                onFailure(it)
                onComplete.invoke()
            }

            SUCCESS -> viewState.data?.let {
                onSuccess(it)
                onComplete.invoke()
            }

            else -> onNeutral()
        }
    }
}

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) = postValue(ViewState(status = SUCCESS, data = data))

fun <T> MutableLiveData<ViewState<T>>.postFailure(throwable: Throwable) = postValue(
    ViewState(status = ERROR, throwable = throwable)
)

fun <T> MutableLiveData<ViewState<T>>.postLoading() = postValue(ViewState(status = LOADING))

fun <T> MutableLiveData<ViewState<T>>.postNeutral() = postValue(ViewState(status = NEUTRAL))

fun createFieldState() = MutableLiveData<FieldState>().also { it.value = FieldState.NEUTRAL }