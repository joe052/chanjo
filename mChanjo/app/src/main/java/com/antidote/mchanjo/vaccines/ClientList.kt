package com.antidote.mchanjo.vaccines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antidote.mchanjo.Client
import com.antidote.mchanjo.ClientListAdapter
import com.antidote.mchanjo.R


class ClientList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var clientListAdapter: ClientListAdapter
    private lateinit var clientList: ArrayList<Client>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_list)

        clientList = ArrayList()
        clientList.add(Client("John Doe", "Male"))
        clientList.add(Client("Jane Smith", "Female"))

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        clientListAdapter = ClientListAdapter(clientList)
        recyclerView.adapter = clientListAdapter
    }
}


