package com.antidote.mchanjo.vaccines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.antidote.mchanjo.R

class Covid : AppCompatActivity() {

    private lateinit var autoCompleteTextView: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_19_vaccine)

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

    }
}