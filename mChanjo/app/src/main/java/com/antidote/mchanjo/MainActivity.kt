package com.antidote.mchanjo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.fhir.datacapture.QuestionnaireFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
//The below line hides the actionbar to give the splash screen a clear view
        supportActionBar?.hide()

        var clientList = mutableListOf(
            Client("Joe Karanja","man"),
            Client("Blessed Kimani","man"),
        )

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.imHome -> setCurrentPage(ClientListFragment(clientList))
                R.id.imGuidelines -> setCurrentPage(GuidelineFragment())
            }
            true
        }

        // Set the initial page to the ClientListFragment when the activity is created
        setCurrentPage(ClientListFragment(clientList))
    }
    private fun setCurrentPage(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment) // Use the correct fragment container ID here
            commit()
        }
    }
}