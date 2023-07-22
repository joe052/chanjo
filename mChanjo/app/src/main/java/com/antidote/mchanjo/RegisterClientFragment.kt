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

//    private val questionnaireFragmentTag = "QuestionnaireFragmentTag"
    var questionnaireJsonString: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.register_client, container, false)

        //Add a questionnaire fragment.
        questionnaireJsonString = getStringFromAssets("patient2_questionnaire.json")

//        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add(
//                    R.id.fragment_container_view,
//                    QuestionnaireFragment.builder().setQuestionnaire(questionnaireJsonString!!).build()
//                )
//            }
//        }
        return rootView
    }

    private fun getStringFromAssets(fileName: String): String? {
        return try {
            val inputStream = requireContext().assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer)
        } catch (e: Exception) {
            Log.e("RegisterClientFragment", "Error reading JSON from assets", e)
            null
        }
    }
}
