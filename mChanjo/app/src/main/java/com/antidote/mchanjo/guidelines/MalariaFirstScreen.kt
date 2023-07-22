package com.antidote.mchanjo.guidelines

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.antidote.mchanjo.R

class MalariaFirstScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guidelines_malaria_one)

         val nextTextView: TextView = findViewById(R.id.next2)

         nextTextView.setOnClickListener {
        // Create an Intent to start the TargetActivity
            val intent = Intent(this, MalariaSecondScreen::class.java)

        // Start the TargetActivity
            startActivity(intent)
        }
    }
}