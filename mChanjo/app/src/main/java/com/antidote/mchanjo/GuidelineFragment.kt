package com.antidote.mchanjo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController

class GuidelineFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_guidelines, container, false)

        val bcgButton: AppCompatButton = rootView.findViewById(R.id.BCGButton)
        val hpvButton: AppCompatButton = rootView.findViewById(R.id.HPVButton)
        val malariaButton: AppCompatButton = rootView.findViewById(R.id.MalariaButton)

        // Set click listeners for each button to navigate to the corresponding guideline page
        bcgButton.setOnClickListener {
            // Navigate to the BCG guideline page (Replace the destination with your desired fragment)
            //findNavController().navigate(/* Replace with the BCG guideline destination */)
        }

        hpvButton.setOnClickListener {
            // Navigate to the HPV guideline page (Replace the destination with your desired fragment)
            //findNavController().navigate(/* Replace with the HPV guideline destination */)
        }

        malariaButton.setOnClickListener {
            // Navigate to the Malaria guideline page (Replace the destination with your desired fragment)
            findNavController().navigate(R.id.viewGuidelinesPageFragment)
        }

        return rootView
    }
}
