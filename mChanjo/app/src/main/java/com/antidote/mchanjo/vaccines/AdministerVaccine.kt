package com.antidote.mchanjo.vaccines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antidote.mchanjo.R
import com.google.android.material.card.MaterialCardView

class AdministerVaccine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_vaccines)

        val vaccine2CardView: MaterialCardView = findViewById(R.id.Vaccine2)
        vaccine2CardView.setOnClickListener {
            val intent = Intent(this, BCG::class.java)
            startActivity(intent)
        }
        val vaccineCardView: MaterialCardView = findViewById(R.id.Vaccine)
        vaccineCardView.setOnClickListener {
            val intent = Intent(this, HPV::class.java)
            startActivity(intent)
        }
        val vaccine3CardView: MaterialCardView = findViewById(R.id.Vaccine3)
        vaccine3CardView.setOnClickListener {
            val intent = Intent(this, Malaria::class.java)
            startActivity(intent)
        }
    }
}