package com.antidote.mchanjo

import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.Api


class ClientListAdapter(private val clientList: List<Client>) :
    RecyclerView.Adapter<ClientListAdapter.ClientViewHolder>() {

    inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val clientNameTextView: TextView = itemView.findViewById(R.id.clientName)
        private val clientGenderTextView: TextView = itemView.findViewById(R.id.clientGender)

        fun bind(client: Client) {
            clientNameTextView.text = client.name
            clientGenderTextView.text = client.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_client_list, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clientList[position]
        holder.bind(client)
    }

    override fun getItemCount(): Int {
        return clientList.size
    }



private fun Intent.putExtra(s: String, client: Api.Client) {

}}

