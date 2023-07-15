package com.antidote.mchanjo.vaccines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antidote.mchanjo.Client
import com.antidote.mchanjo.ClientListAdapter
import com.antidote.mchanjo.R
import androidx.appcompat.widget.SearchView



class ClientList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var clientListAdapter: ClientListAdapter
    private lateinit var clientList: ArrayList<Client>

//   override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.view_list)
//
//        clientList = ArrayList()
//        clientList.add(Client("John Doe", "Male"))
//        clientList.add(Client("Jane Smith", "Female"))
//
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        clientListAdapter = ClientListAdapter(clientList)
//        recyclerView.adapter = clientListAdapter
//    }
//}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_list)

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Replace this with your actual list of clients
        clientList = generateClientList() as ArrayList<Client>

        // Create and set the adapter
        clientListAdapter = ClientListAdapter(clientList)
        recyclerView.adapter = clientListAdapter
    }

    private fun generateClientList(): List<Client> {
        // Replace this with your actual data retrieval logic
        val clientList = mutableListOf<Client>()
        clientList.add(Client("John Doe", "Male"))
        clientList.add(Client("Jane Smith", "Female"))
        // Add more clients as needed
        return clientList
    }
}


