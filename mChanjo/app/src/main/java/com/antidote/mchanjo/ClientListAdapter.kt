package com.antidote.mchanjo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClientListAdapter(private val clientList: List<Client>) :
    RecyclerView.Adapter<ClientListAdapter.ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_client_list, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clientList[position]
        holder.bind(client)
    }

    override fun getItemCount(): Int {
        return clientList.size
    }

    inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(client: Client) {
            // Set data to the views in the card layout
            itemView.findViewById<TextView>(R.id.clientName).text = client.name
            itemView.findViewById<TextView>(R.id.clientGender).text = client.gender
        }
    }
}
