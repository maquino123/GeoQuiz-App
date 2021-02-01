package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0
    var isCheater = false
    private val questionBank = listOf(
            Question(R.string.question_spongebob, false, false),
            Question(R.string.question_patrick, false, false),
            Question(R.string.question_plankton, true, false),
            Question(R.string.question_pearl, true, false),
            Question(R.string.question_krabs, false, false),
            Question(R.string.question_clarinet, true, false)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val nextQuestionAnswered:Boolean
        get() = questionBank[currentIndex + 1].answered

    val prevQuestionAnswered:Boolean
        get() = questionBank[currentIndex - 1].answered

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrevious() {
        if (currentIndex != 0) {
            currentIndex = (currentIndex - 1) % questionBank.size
        }
    }

    fun isAnswered(state:Boolean){
        questionBank[currentIndex].answered=state
    }

}