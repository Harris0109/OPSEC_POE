package com.example.moneymate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuestionnaireActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var progressTracker: TextView
    private lateinit var answerGroup: RadioGroup
    private lateinit var feedbackText: TextView
    private lateinit var submitButton: Button

    private val questions = listOf(
        "How often do you budget your spending?",
        "Do you save a portion of your income every month?",
        "How do you track your expenses?",
        "Do you set financial goals?",
        "How often do you review your spending habits?"
    )

    private val options = listOf(
        listOf("Always", "Sometimes", "Never"),
        listOf("Yes, always", "Occasionally", "Never"),
        listOf("App/Spreadsheet", "Notebook", "I don't"),
        listOf("Yes", "No, but I want to", "No"),
        listOf("Weekly", "Monthly", "Rarely")
    )

    private val feedback = mutableListOf<String>()
    private var currentQuestionIndex = 0
    private var quizFinished = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)

        questionText = findViewById(R.id.question1)
        progressTracker = findViewById(R.id.progressTracker)
        answerGroup = findViewById(R.id.answerGroup)
        feedbackText = findViewById(R.id.feedbackText)
        submitButton = findViewById(R.id.submitButton)

        showQuestion()

        submitButton.setOnClickListener {
            if (!quizFinished) {
                val selectedId = answerGroup.checkedRadioButtonId
                if (selectedId == -1) {
                    feedbackText.text = "Please select an option before continuing."
                    feedbackText.visibility = View.VISIBLE
                    return@setOnClickListener
                }

                val selectedAnswer = findViewById<RadioButton>(selectedId).text.toString()
                feedback.add(selectedAnswer)

                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    showQuestion()
                } else {
                    // Show categorized result visibly on screen
                    val resultMessage = categorizeUser(feedback)

                    // Display interactive result in the feedback text
                    feedbackText.text = resultMessage
                    feedbackText.visibility = View.VISIBLE

                    submitButton.text = "Go to Dashboard"
                    quizFinished = true
                }
            } else {
                // ✅ Fixed navigation to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }

    private fun showQuestion() {
        // Update UI for current question
        questionText.text = questions[currentQuestionIndex]
        progressTracker.text = "Question ${currentQuestionIndex + 1} of ${questions.size}"
        feedbackText.visibility = View.GONE

        answerGroup.removeAllViews()
        for (option in options[currentQuestionIndex]) {
            val radioButton = RadioButton(this)
            radioButton.text = option
            answerGroup.addView(radioButton)
        }
    }

    private fun categorizeUser(answers: List<String>): String {
        val positiveAnswers = listOf("Always", "Yes, always", "App/Spreadsheet", "Yes", "Weekly")
        val score = answers.count { it in positiveAnswers }

        return when {
            score >= 4 -> "🎉 Money Master! You're excellent with your finances."
            score == 3 -> "👍 Smart Spender – you're doing quite well!"
            score == 2 -> "😐 Budget Explorer – there's room to grow."
            else -> "🚨 Budget Rookie – time to build strong money habits!"
        }
    }
}
