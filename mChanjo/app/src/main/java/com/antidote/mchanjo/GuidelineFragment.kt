package com.antidote.mchanjo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.antidote.mchanjo.guidelines.BCGFirstScreen
import com.antidote.mchanjo.guidelines.HPVFirstScreen
import com.antidote.mchanjo.guidelines.MalariaFirstScreen

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
            val intent = Intent(context, BCGFirstScreen::class.java)
            startActivity(intent)
        }

        hpvButton.setOnClickListener {
            val intent = Intent(context, HPVFirstScreen::class.java)
            startActivity(intent)
        }

        malariaButton.setOnClickListener {
            val intent = Intent(context, MalariaFirstScreen::class.java)
            startActivity(intent)
        }

        return rootView
    }
}
