package com.example.moneymate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class QuestionnaireActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)  // Ensure this file exists in res/layout

        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Navigates back to main screen
            startActivity(intent)
            finish() // Closes QuestionnaireActivity
        }
    }
}
