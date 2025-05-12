package com.example.moneymate

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BudgetActivity : AppCompatActivity() {

    private lateinit var iconBack: ImageView
    private lateinit var btnCreateCategory: Button
    private lateinit var btnAddExpense: Button
    private lateinit var btnSetMonthlyGoals: Button
    private lateinit var btnViewExpenses: Button
    private lateinit var btnCategorySummary: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget)

        // ✅ Bind views FIRST before using them
        iconBack = findViewById(R.id.iconBack)
        btnCreateCategory = findViewById(R.id.btnCreateCategory)
        btnAddExpense = findViewById(R.id.btnAddExpense)
        btnSetMonthlyGoals = findViewById(R.id.btnSetMonthlyGoals)
        btnViewExpenses = findViewById(R.id.btnViewExpenses)
        btnCategorySummary = findViewById(R.id.btnCategorySummary)

        // ✅ Now set click listeners AFTER binding views
        iconBack.setOnClickListener {
            finish() // Go back to previous screen
        }

        btnCreateCategory.setOnClickListener {
            Toast.makeText(this, "Navigate to Create Category screen (coming soon)", Toast.LENGTH_SHORT).show()
        }

        btnAddExpense.setOnClickListener {
            Toast.makeText(this, "Navigate to Add Expense screen (coming soon)", Toast.LENGTH_SHORT).show()
        }

        btnSetMonthlyGoals.setOnClickListener {
            Toast.makeText(this, "Navigate to Set Monthly Goals screen (coming soon)", Toast.LENGTH_SHORT).show()
        }

        btnViewExpenses.setOnClickListener {
            Toast.makeText(this, "Navigate to View Expenses screen (coming soon)", Toast.LENGTH_SHORT).show()
        }

        btnCategorySummary.setOnClickListener {
            Toast.makeText(this, "Navigate to Category Summary screen (coming soon)", Toast.LENGTH_SHORT).show()
        }
    }
}
