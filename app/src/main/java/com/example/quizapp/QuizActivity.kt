package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private val questions = listOf(
        Question("What is the capital of France?", listOf("Paris", "Rome", "Berlin", "Madrid"), 0),
        Question("Who developed Kotlin?", listOf("Google", "JetBrains", "Microsoft", "Oracle"), 1),
        Question("Which is the smallest planet in our solar system?", listOf("Earth", "Venus", "Mars", "Mercury"), 3),
    )
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadQuestion()

        binding.btnNext.setOnClickListener {
            checkAnswer()
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                binding.quizContent.visibility = android.view.View.GONE
                binding.resultContent.visibility = android.view.View.VISIBLE
                binding.tvScore.text = "Your Score: $score/${questions.size}"
            }
        }
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        binding.tvQuestion.text = question.text
        binding.radioGroupOptions.clearCheck()
        binding.radioOption1.text = question.options[0]
        binding.radioOption2.text = question.options[1]
        binding.radioOption3.text = question.options[2]
        binding.radioOption4.text = question.options[3]
    }

    private fun checkAnswer() {
        val selectedOption = when (binding.radioGroupOptions.checkedRadioButtonId) {
            binding.radioOption1.id -> 0
            binding.radioOption2.id -> 1
            binding.radioOption3.id -> 2
            binding.radioOption4.id -> 3
            else -> -1
        }
        if (selectedOption == questions[currentQuestionIndex].correctOption) {
            score++
        }
    }
}

data class Question(val text: String, val options: List<String>, val correctOption: Int)
