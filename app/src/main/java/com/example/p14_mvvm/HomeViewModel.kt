package com.example.p14_mvvm

import android.content.Context
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val sheardPref = application.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    val editor = sheardPref.edit()

    private var _scoreTeamOne = MutableLiveData<Int>()
    private var _scoreTeamTwo = MutableLiveData<Int>()
    private var _finalResult = MutableLiveData<String>()

    val scoreTeamOne: MutableLiveData<Int> get() = _scoreTeamOne
    val scoreTeamTwo: MutableLiveData<Int> get() = _scoreTeamTwo
    val finalResult: MutableLiveData<String> get() = _finalResult

    init {
        _scoreTeamOne.value = sheardPref.getInt("teamOne", 0)
        _scoreTeamTwo.value = sheardPref.getInt("teamTwo", 0)
        _finalResult.value = "Draw"
    }

    fun clear() {
        _scoreTeamOne.value = 0
        _scoreTeamTwo.value = 0
        editor.clear().apply()
        editor.putInt("teamOne", 0)
        editor.putInt("teamTwo", 0)
        editor.apply()
    }

    fun checkFinalResult() {
        _finalResult.value = when {
            _scoreTeamOne.value!! > _scoreTeamTwo.value!! -> "team one is winner"
            _scoreTeamOne.value!! < _scoreTeamTwo.value!! -> "team Two is winner"
            else -> "Draw"
        }
    }

    fun increaseTeamOneScore() {
        _scoreTeamOne.value = (_scoreTeamOne.value ?: 0) + 1
        editor.putInt("teamOne", _scoreTeamOne.value!!)
        editor.apply()
    }

    fun increaseTeamTwoScore() {
        _scoreTeamTwo.value = (_scoreTeamTwo.value ?: 0) + 1
        editor.putInt("teamTwo", _scoreTeamTwo.value!!)
        editor.apply()
    }

}


