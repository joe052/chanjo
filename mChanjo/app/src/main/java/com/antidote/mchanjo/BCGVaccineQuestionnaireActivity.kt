package com.antidote.mchanjo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.google.android.fhir.datacapture.QuestionnaireFragment

class BCGVaccineQuestionnaireActivity : AppCompatActivity() {

    var questionnaireJsonString: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_client)

        //Add a questionnaire fragment.
        questionnaireJsonString = getStringFromAssets("BCG-Immunization-Form.R4.json")

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.fragment_container_view,
                    QuestionnaireFragment.builder().setQuestionnaire(questionnaireJsonString!!).build()
                )
            }
        }
    }
    private fun getStringFromAssets(fileName: String): String {
        return assets.open(fileName).bufferedReader().use { it.readText() }
    }
}