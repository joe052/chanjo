package com.antidote.mchanjo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
//The below line hides the actionbar to give the splash screen a clear view
        supportActionBar?.hide()

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

//    private fun setCurrentPage(fragment: Fragment) {
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentContainer, fragment) // Use the correct fragment container ID here
//            commit()
//        }
//    }
    private fun setCurrentPage(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment) // Use the correct fragment container ID here
            commit()
        }
    }

}