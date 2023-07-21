package com.antidote.mchanjo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ClientListFragment(private val clientList: List<Client>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_client_list, container, false)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        val adapter = ClientListAdapter(clientList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // Find the button and set a click listener to open the QuestionnaireFragment
        val addClientButton: Button = rootView.findViewById(R.id.AddClientButton)

        addClientButton.setOnClickListener {
            val registerClientFragment = RegisterClientFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, registerClientFragment) // Replace fragment_container with the ID of the container where you want to display the RegisterClientFragment
                .addToBackStack(null)
                .commit()
        }
        return rootView
    }
}