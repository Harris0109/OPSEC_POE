package com.example.moneymate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BudgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        // Set Welcome Text
        val userName = "Franklin Ngangu"  // Replace with actual signed in user's name later
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        welcomeText.text = "Welcome, $userName!"

        // Set Button Click to open CreateCategoryActivity
        val btnCreateCategory = findViewById<Button>(R.id.btnCreateCategory)
        btnCreateCategory.setOnClickListener {
            val intent = Intent(this, CreateCategoryActivity::class.java)
            startActivity(intent)
        }

        // Set Button Click to open TrackExpenseActivity
        val btnAddExpense = findViewById<Button>(R.id.btnAddExpense)
        btnAddExpense.setOnClickListener {
            val intent = Intent(this, TrackExpenseActivity::class.java)
            startActivity(intent)
        }

        // Set Button Click to open GoalsActivity
        val btnSetMonthlyGoals = findViewById<Button>(R.id.btnSetMonthlyGoals)
        btnSetMonthlyGoals.setOnClickListener {
            val intent = Intent(this, GoalsActivity::class.java)
            startActivity(intent)
        }

        // Set Button Click to open ViewExpensesActivity
        val btnViewExpenses = findViewById<Button>(R.id.btnViewExpenses)
        btnViewExpenses.setOnClickListener {
            val intent = Intent(this, ViewExpensesActivity::class.java)
            startActivity(intent)
        }

        // Set Button Click to open CategorySummaryActivity
        val btnCategorySummary = findViewById<Button>(R.id.btnCategorySummary)
        btnCategorySummary.setOnClickListener {
            val intent = Intent(this, CategorySummaryActivity::class.java)
            startActivity(intent)
        }





    }
}


