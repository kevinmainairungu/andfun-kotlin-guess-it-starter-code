/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import timber.log.Timber


/**
 * Fragment where the game is played
 */
// create constant values for the word to be used on savedInstanceState and onRestoreInstanceState
const val WORD_VALUE = "WORD_WORD"

const val SCORE_VALUE = "SCORE_SCORE"

class GameFragment : Fragment() {

//    make a field for the new ViewModel

    private lateinit var viewModel: GameViewModel


    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )
// viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java) earlier versions of the ViewModel class and it has been deprecated

        Timber.i("Called ViewModelProviders of")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)


        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
            updateWordText()
        }
        binding.skipButton.setOnClickListener {
            viewModel.onSkip()

            updateWordText()

        }
        viewModel.score.observe(this, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        updateWordText()
        return binding.root

    }



   fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_LONG).show()
//        We use the elvis operator to check if the score value is not null. If it is give it the value 0
        val currentScore = viewModel.score.value ?: 0
        val action = GameFragmentDirections.actionGameToScore(currentScore)
       findNavController(this).navigate(action)
    }

    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = viewModel.word.toString()

    }

}
