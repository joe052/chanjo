package com.antidote.mchanjo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ClientListAdapter(
    var clients: List<Client>
) : RecyclerView.Adapter<ClientListAdapter.ClientListViewHolder>() {

    inner class ClientListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientName: TextView = itemView.findViewById(R.id.clientName)
        val clientGender: TextView = itemView.findViewById(R.id.clientGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_client_list, parent, false)
        return ClientListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientListViewHolder, position: Int) {
        val client = clients[position]
        holder.clientName.text = client.clientName
        holder.clientGender.text = client.clientGender
    }

    override fun getItemCount(): Int {
       return clients.size
    }

}