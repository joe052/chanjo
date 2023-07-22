package com.antidote.mchanjo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class ClientRecordsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.recordspage, container, false)

        // Get references to the TextView elements
        val clientsNameTextView: TextView = rootView.findViewById(R.id.clientsName)
        val clientsGenderTextView: TextView = rootView.findViewById(R.id.clientsGender)

        // Get client details from arguments (passed from previous fragment/activity)
        val clientName = requireArguments().getString("CLIENT_NAME")
        val clientGender = requireArguments().getString("CLIENT_GENDER")

        // Set client details in the TextView elements
        clientsNameTextView.text = "Name: $clientName"
        clientsGenderTextView.text = "Gender: $clientGender"

        // Find the MaterialCardViews representing different records
        val bcgCard: MaterialCardView = rootView.findViewById(R.id.BCGCard)
        val hpvCard: MaterialCardView = rootView.findViewById(R.id.HPVcard)
        val malariaCard: MaterialCardView = rootView.findViewById(R.id.Malariacard)

        // Set click listeners for each card
        bcgCard.setOnClickListener {
            val intent = Intent(context, BCGVaccineQuestionnaireActivity::class.java)
            startActivity(intent)
        }

        hpvCard.setOnClickListener {
            val intent = Intent(context, HPVVaccineQuestionnaireActivity::class.java)
            startActivity(intent)
        }

        malariaCard.setOnClickListener {
            val intent = Intent(context, MalariaVaccineQuestionnaireActivity::class.java)
            startActivity(intent)
        }
        return rootView
    }

}

