package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel() {

     var word = ""

    // The current score
     var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


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

    init {
        resetList()
        nextWord()
    }


    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
//            GameFinished()
        } else {
            word = wordList.removeAt(0)
        }
    }

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

//this is called every time the ViewModel is about to be destroyed

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed")
    }
}