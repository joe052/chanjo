package com.antidote.mchanjo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = ClientListAdapter(clientList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


    }
}