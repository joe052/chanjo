package com.antidote.mchanjo.vaccines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antidote.mchanjo.R
import androidx.appcompat.widget.AppCompatButton
import android.app.DatePickerDialog
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class BCG : AppCompatActivity() {

    private lateinit var submitButton: AppCompatButton
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var dose1EditText: AutoCompleteTextView
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bcg_vaccine)

        // Initialize views
        submitButton = findViewById(R.id.submitButton)
        autoCompleteTextView = findViewById(R.id.auto_complete_txt)
        dose1EditText = findViewById(R.id.auto_complete_txt1)

        setupAutoCompleteTextView(autoCompleteTextView)

        val options = arrayOf(
            "AstraZeneca/Oxford vaccine",
            "Johnson and Johnson",
            "Moderna",
            "Pfizer/BioNTech",
            "Sinopharm",
            "Sinovac",
            "COVAXIN",
            "Covovax",
            "Nuvaxovid"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, options)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.threshold = 1

        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedOption = parent.getItemAtPosition(position) as String
            Toast.makeText(applicationContext, "selected: $selectedOption", Toast.LENGTH_SHORT)
                .show()
        }

        submitButton.setOnClickListener {
            // Perform the desired action when the submit button is clicked
        }
    }

    private fun setupAutoCompleteTextView(autoCompleteTextView: AutoCompleteTextView) {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val dateSuggestions = arrayOf(
            dateFormat.format(Date()),  // Today's date
            dateFormat.format(calendar.apply { add(Calendar.DAY_OF_MONTH, 1) }.time),  // Tomorrow's date
            dateFormat.format(calendar.apply { add(Calendar.DAY_OF_MONTH, 1) }.time)   // Next day's date
        )

        val adapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, dateSuggestions)
        autoCompleteTextView.setAdapter(adapter)

        val datePickerListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateField(autoCompleteTextView)
            }

        autoCompleteTextView.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val datePickerDialog = DatePickerDialog(
                    this,
                    datePickerListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                datePickerDialog.show()
            }
        }
    }

    private fun updateDateField(autoCompleteTextView: AutoCompleteTextView) {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        autoCompleteTextView.setText(dateFormat.format(calendar.time))
    }
}
