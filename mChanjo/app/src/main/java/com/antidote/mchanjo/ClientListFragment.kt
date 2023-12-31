package com.antidote.mchanjo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ClientListFragment(private val clientList: List<Client>) : Fragment(), ClientListAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_client_list, container, false)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)

        // Pass the 'this' reference of the ClientListFragment as the onItemClickListener
        val adapter = ClientListAdapter(clientList, this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        val addClientButton: Button = rootView.findViewById(R.id.AddClientButton)

        // Set the click listener for the button
        addClientButton.setOnClickListener{
            // Navigate to another activity when the button is clicked
            val intent = Intent(context, RegisterQuestionnaireActivity::class.java)
            startActivity(intent)
        }

        return rootView
    }


    override fun onItemClick(client: Client) {
        val clientRecordsFragment = ClientRecordsFragment()

        // Pass client details as arguments to the ClientRecordsFragment
        val bundle = Bundle()
        bundle.putString("CLIENT_NAME", client.clientName)
        bundle.putString("CLIENT_GENDER", client.clientGender)
        clientRecordsFragment.arguments = bundle

        parentFragmentManager.commit {
            replace(R.id.fragment_container_view, clientRecordsFragment)
            addToBackStack(null)
        }
    }
}






