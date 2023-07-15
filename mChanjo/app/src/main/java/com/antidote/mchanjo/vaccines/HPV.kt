package com.antidote.mchanjo.vaccines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antidote.mchanjo.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class HPV : AppCompatActivity() {

    private lateinit var submitButton: MaterialButton
    private lateinit var autoCompleteTextView: TextInputEditText
    private lateinit var dose1EditText: TextInputEditText
    private lateinit var dose2EditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hpv_vaccine)

        // Initialize views
        submitButton = findViewById(R.id.submitButton)
        autoCompleteTextView = findViewById(R.id.auto_complete_txt)
        dose1EditText = findViewById(R.id.auto_complete_txt1)
        dose2EditText = findViewById(R.id.auto_complete_txt3)

        // Set click listener for the submit button
        submitButton.setOnClickListener {
            // Perform the desired action when the submit button is clicked
        }
    }
}

