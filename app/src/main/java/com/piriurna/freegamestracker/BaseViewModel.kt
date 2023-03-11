package com.piriurna.freegamestracker

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : BaseEvent, S : UiState> : ViewModel(){

    private val _uiState : MutableState<S> by lazy { mutableStateOf(initialState()) }
    val uiState : MutableState<S> = _uiState

    abstract fun initialState() : S

    protected fun updateStateTo(newState : S) {
        _uiState.value = newState
    }

    abstract fun onEventTriggered(event: T)
}