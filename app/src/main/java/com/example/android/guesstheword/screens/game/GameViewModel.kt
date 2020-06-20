package com.example.android.guesstheword.screens.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {
    var word = ""

    // The current score
    val score = MutableLiveData<Int>()

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        resetList()
        nextWord()
        score.value = 0
    }


    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }


    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
//             GameFinished()
        } else {
            word = wordList.removeAt(0)
        }
    }

    //  the score value is null we can add a null checker and call the minus method passing in 1
//  Subtracting but with null safety
    fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }
// addition with null safety
    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

//this is called every time the ViewModel is about to be destroyed

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed")
    }
}