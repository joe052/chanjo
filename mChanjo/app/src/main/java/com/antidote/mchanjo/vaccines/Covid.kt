package com.antidote.mchanjo.vaccines

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.antidote.mchanjo.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Covid : AppCompatActivity() {

    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_19_vaccine)

        //select option text view
        autoCompleteTextView = findViewById(R.id.auto_complete_txt)

        val options = arrayOf("AstraZeneca/Oxford vaccine",
                "Johnson and Johnson",
                "Moderna" ,
                "Pfizer/BioNTech",
                "Sinopharm",
                "Sinovac",
                "COVAXIN",
                "Covovax" ,
                "Nuvaxovid")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, options)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.threshold = 1

        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedOption = parent.getItemAtPosition(position) as String
            Toast.makeText(applicationContext, "selected: $selectedOption", Toast.LENGTH_SHORT).show()
        }

        //date picker text view
        autoCompleteTextView = findViewById(R.id.auto_complete_txt1)

        val datePickerListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateField()
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

        // Set up the AutoCompleteTextView with date suggestions
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val dateSuggestions = arrayOf(
            dateFormat.format(Date()),  // Today's date
            dateFormat.format(calendar.apply { add(Calendar.DAY_OF_MONTH, 1) }.time),  // Tomorrow's date
            dateFormat.format(calendar.apply { add(Calendar.DAY_OF_MONTH, 1) }.time)   // Next day's date
        )

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, dateSuggestions)
        autoCompleteTextView.setAdapter(adapter1)

        autoCompleteTextView = findViewById(R.id.auto_complete_txt2)
        autoCompleteTextView = findViewById(R.id.auto_complete_txt3)
    }private fun updateDateField() {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        autoCompleteTextView.setText(dateFormat.format(calendar.time))
    }




}