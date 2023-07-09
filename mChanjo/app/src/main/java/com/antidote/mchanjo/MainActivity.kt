package com.antidote.mchanjo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//The below line hides the actionbar to give the splash screen a clear view
        supportActionBar?.hide()
    }
}