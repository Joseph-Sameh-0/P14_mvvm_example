package com.example.p14_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var _scoreTeamOne = MutableLiveData<Int>()
    val scoreTeamOne: MutableLiveData<Int> get() = _scoreTeamOne

    private var _scoreTeamTwo = MutableLiveData<Int>()
    val scoreTeamTwo: MutableLiveData<Int> get() = _scoreTeamTwo

    init {
        _scoreTeamOne.value = 0
        _scoreTeamTwo.value = 0
    }


    fun increaseTeamOneScore() {
        val currentScore = _scoreTeamOne.value
        if (currentScore != null) _scoreTeamOne.value = currentScore + 1
    }

    fun increaseTeamTwoScore() {
        val currentScore = _scoreTeamTwo.value
        if (currentScore != null) _scoreTeamTwo.value = currentScore + 1
    }

}

