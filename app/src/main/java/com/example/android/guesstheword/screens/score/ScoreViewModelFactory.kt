package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

// creating the viewModel factory with view Members
// create a viewmodel provider
class ScoreViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        Timber.i("viewModelFactory invoked")
        TODO("Not yet implemented")
    }
}