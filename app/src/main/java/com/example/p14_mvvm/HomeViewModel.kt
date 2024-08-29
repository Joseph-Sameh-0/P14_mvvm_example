package com.example.p14_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var _scoreTeamOne = MutableLiveData<Int>()
    val scoreTeamOne: MutableLiveData<Int> get() = _scoreTeamOne

    private var _scoreTeamTwo = MutableLiveData<Int>()
    val scoreTeamTwo: MutableLiveData<Int> get() = _scoreTeamTwo

    private var _finalResult = MutableLiveData<String>()
    val finalResult: MutableLiveData<String> get() = _finalResult

    init {
        _scoreTeamOne.value = 0
        _scoreTeamTwo.value = 0
        _finalResult.value = "Draw"
    }

    fun checkFinalResult() {
        if (scoreTeamOne.value == scoreTeamTwo.value) _finalResult.value = "Draw"
        else if (_scoreTeamOne.value!! > _scoreTeamTwo.value!!) _finalResult.value = "team one is winner"
        else if (_scoreTeamOne.value!! < _scoreTeamTwo.value!!) _finalResult.value = "team Two is winner"
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

