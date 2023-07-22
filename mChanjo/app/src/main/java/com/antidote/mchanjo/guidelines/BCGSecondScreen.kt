package com.antidote.mchanjo.guidelines

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.antidote.mchanjo.R


class BCGSecondScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guideline_bcg_2)

        val nextTextView: TextView = findViewById(R.id.next2)

        nextTextView.setOnClickListener {
            // Create an Intent to start the TargetActivity
            val intent = Intent(this, BCGThirdScreen::class.java)

            // Start the TargetActivity
            startActivity(intent)
        }
    }
}