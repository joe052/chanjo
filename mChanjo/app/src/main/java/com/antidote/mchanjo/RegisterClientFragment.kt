package com.antidote.mchanjo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.fhir.datacapture.QuestionnaireFragment

class RegisterClientFragment : Fragment() {

    private val questionnaireFragmentTag = "QuestionnaireFragmentTag"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.register_client, container, false)

        val questionnaireJson = requireContext().assets.open("new-patient-registration-paginated.json").bufferedReader().use { it.readText() }

        if (savedInstanceState == null) {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.fragment_container_view, // Use the correct container ID here
                    QuestionnaireFragment.Builder().setQuestionnaire(questionnaireJson).build(),
                    questionnaireFragmentTag
                )
            }
        }
        return rootView
    }
}
