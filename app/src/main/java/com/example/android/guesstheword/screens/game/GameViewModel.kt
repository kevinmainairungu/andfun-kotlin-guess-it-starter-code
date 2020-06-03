package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {
    init {
        Timber.i("GameViewModel has been called")
    }
//this is called every time the ViewModel is about to be destroyed

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel has been destroyed")
    }
}