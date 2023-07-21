package com.antidote.mchanjo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.fhir.datacapture.QuestionnaireFragment
import com.google.android.material.card.MaterialCardView
import android.content.res.AssetManager
import java.io.IOException

class ClientRecordsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.recordspage, container, false)

        // Find the MaterialCardViews representing different records
        val bcgCard: MaterialCardView = rootView.findViewById(R.id.BCGCard)
        val hpvCard: MaterialCardView = rootView.findViewById(R.id.HPVcard)
        val malariaCard: MaterialCardView = rootView.findViewById(R.id.Malariacard)

        // Set click listeners for each card
        bcgCard.setOnClickListener {
            // Show the questionnaire when BCG card is clicked
            showQuestionnaireFragment("new-patient-registration-paginated.json")
        }

        hpvCard.setOnClickListener {
            // Show the questionnaire when HPV card is clicked
            showQuestionnaireFragment("new-patient-registration-paginated.json")
        }

        malariaCard.setOnClickListener {
            // Show the questionnaire when Malaria card is clicked
            showQuestionnaireFragment("new-patient-registration-paginated.json")
        }

        return rootView
    }
    private fun showQuestionnaireFragment(questionnaireFileName: String) {
        val questionnaireJson = readQuestionnaireFromAssets(questionnaireFileName, requireContext())
        val questionnaireFragment = QuestionnaireFragment.Builder()
            .setQuestionnaire(questionnaireJson)
            .build()

        parentFragmentManager.commit {
            replace(R.id.fragment_container_view, questionnaireFragment)
            addToBackStack(null)
        }
    }
    private fun readQuestionnaireFromAssets(fileName: String, context: Context): String {
        try {
            // Open the JSON file from the assets folder and read its content
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            // Convert the bytes to a String and return the JSON content
            return String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return ""
    }
}

