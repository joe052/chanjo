package com.antidote.mchanjo.guidelines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.antidote.mchanjo.Client
import com.antidote.mchanjo.ClientListFragment
import com.antidote.mchanjo.GuidelineFragment
import com.antidote.mchanjo.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class GuidelinesChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
//The below line hides the actionbar to give the splash screen a clear view
        supportActionBar?.hide()
        // Set the initial page to the ClientListFragment when the activity is created
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigationView.setOnItemSelectedListener { item ->

            var clientList = mutableListOf(
                Client("Immanuel Kimani","Woman"),
                Client("Joe Karanja","man"),
                Client("Blessed Kimani","man"),
                Client("Imma Kinuthia","Woman"),
                Client("manuel Kimani","Woman"),
                Client("manuh Kim","Woman"),
                Client("wilberforce Kienyeji","Woman"),
                Client("MR Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman"),
                Client("Immanuel Kimani","Woman")
            )

            when (item.itemId) {
                R.id.imHome -> setCurrentPage(ClientListFragment(clientList))
                R.id.imGuidelines -> setCurrentPage(GuidelineFragment())
            }
            true
        }
        setCurrentPage(GuidelineFragment())
    }
    private fun setCurrentPage(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment) // Use the correct fragment container ID here
            commit()
        }
    }
}