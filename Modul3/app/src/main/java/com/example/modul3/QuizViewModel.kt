package com.example.modul3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList


class QuizViewModel : ViewModel() {

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val words = ArrayList<String>(listOf("hgrttoee", "kcap", "nlxohoyep"))
    private var currentWordIndex = 0

    fun isUserWordCorrect(userWord: String): Boolean {
        // Implementasikan logika untuk memeriksa jawaban pengguna
        return true
    }

    fun updateScore() {
        _score.value = (_score.value ?: 0) + 20
    }

    fun nextWord() {
        currentWordIndex = (currentWordIndex + 1) % words.size
    }

    fun hasMoreWords(): Boolean {
        return currentWordIndex < words.size - 1
    }
}