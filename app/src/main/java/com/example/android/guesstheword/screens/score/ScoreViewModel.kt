package com.example.android.guesstheword.screens.score
/* ViewModel Factory */

import androidx.lifecycle.ViewModel
import timber.log.Timber

/* create a view model class */
//final score is of type int (invoke the view model constructor)
class ScoreViewModel(finalScore: Int) : ViewModel() {

    init {
        Timber.i("final score is $finalScore")
    }

}