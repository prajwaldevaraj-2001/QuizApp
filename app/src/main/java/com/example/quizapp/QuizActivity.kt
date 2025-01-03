package com.example.quizapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.question_text)
        loadQuestion()
    }

    private fun loadQuestion() {
        val question = Question(
            id = 1,
            questionText = "What is the capital of France?",
            options = listOf("Berlin", "Madrid", "Paris", "Rome"),
            correctAnswerIndex = 2
        )
        questionTextView.text = question.questionText
    }
}
