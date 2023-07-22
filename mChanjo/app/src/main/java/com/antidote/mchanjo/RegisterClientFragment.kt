package com.antidote.mchanjo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.fhir.datacapture.QuestionnaireFragment

class RegisterClientFragment : Fragment() {
    private var questionnaireJsonString: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.register_client, container, false)

        //Add a questionnaire fragment.
        questionnaireJsonString = getStringFromAssets("Questionnaire-questionnaire-sdc-profile-example-render.json")

//        if (savedInstanceState == null) {
//            rootView.post {
//                requireActivity().supportFragmentManager.commit {
//                    add(
//                        R.id.fragment_container_view,
//                        QuestionnaireFragment.builder().setQuestionnaire(questionnaireJsonString!!).build()
//                    )
//                }
//            }
//        }
//

        if (savedInstanceState == null) {
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.fragment_container_view,
                    QuestionnaireFragment.builder().setQuestionnaire(questionnaireJsonString!!).build()
                )
            }
        }
        return rootView
    }

    private fun getStringFromAssets(fileName: String): String {
        return requireContext().assets.open(fileName).bufferedReader().use { it.readText() }
    }
}
