package com.antidote.mchanjo.vaccines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatButton
import com.antidote.mchanjo.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Malaria : AppCompatActivity() {

    private lateinit var submitButton: AppCompatButton
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var dose1EditText: AutoCompleteTextView
    private lateinit var dose2EditText: AutoCompleteTextView
    private lateinit var dose3EditText: AutoCompleteTextView
    private lateinit var dose4EditText: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malaria_vaccine)

        // Initialize views
        submitButton = findViewById(R.id.submitButton)
        autoCompleteTextView = findViewById(R.id.auto_complete_txt)
        dose1EditText = findViewById(R.id.auto_complete_txt1)
        dose2EditText = findViewById(R.id.auto_complete_txt2)
        dose3EditText = findViewById(R.id.auto_complete_txt3)
        dose4EditText = findViewById(R.id.auto_complete_txt4)

        // Set click listener for the submit button
        submitButton.setOnClickListener {
            // Perform the desired action when the submit button is clicked
        }
    }
}
