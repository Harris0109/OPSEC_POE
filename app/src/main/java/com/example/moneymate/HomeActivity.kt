package com.example.moneymate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var accountBalance: TextView
    private lateinit var addAccountButton: Button
    private lateinit var settingsButton: ImageButton
    private lateinit var addIcon: ImageView
    private lateinit var addBudgetButton: Button // ✅ Keeping "Add" button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Bind views
        accountBalance = findViewById(R.id.accountBalance)
        addAccountButton = findViewById(R.id.addAccountButton)
        settingsButton = findViewById(R.id.settingsButton)
        addIcon = findViewById(R.id.addIcon)
        addBudgetButton = findViewById(R.id.btnAddBudget) // ✅ Ensuring this view is found

        // Set default balance
        accountBalance.text = "$0.00"

        // Handle Add Account button
        addAccountButton.setOnClickListener {
            Toast.makeText(this, "Connect your bank account (coming soon)", Toast.LENGTH_SHORT).show()
        }

        // Handle Settings icon
        settingsButton.setOnClickListener {
            Toast.makeText(this, "Settings or Logout (coming soon)", Toast.LENGTH_SHORT).show()
        }

        // ✅ Handle Add Icon to go to BudgetActivity (Fix applied)
        addIcon.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Ensure HomeActivity doesn't interfere
        }

        // ✅ Handle "Add" button click to go to BudgetActivity (Fix applied)
        addBudgetButton.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish() // Ensure smooth transition
        }
    }
}
