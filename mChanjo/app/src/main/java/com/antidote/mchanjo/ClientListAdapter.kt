package com.antidote.mchanjo

import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//class ClientListAdapter(private val data: ArrayList<Client>) :
//    RecyclerView.Adapter<ClientListAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textName: TextView = itemView.findViewById(R.id.clientName)
//        val textGender: TextView = itemView.findViewById(R.id.clientGender)
//
//        init {
//            itemView.setOnClickListener { v: View ->
//                val i = Intent(v.context, Call.Details::class.java)
//                i.putExtra("title", data[adapterPosition])
//                v.context.startActivity(i)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_client_list, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val title = data[position]
//        holder.textName.text = title.toString()
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//}


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
}


private fun Intent.putExtra(s: String, client: Client) {

}

