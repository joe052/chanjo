package com.antidote.mchanjo

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.android.fhir.BuildConfig
import com.google.android.fhir.DatabaseErrorStrategy.RECREATE_AT_OPEN
import com.google.android.fhir.FhirEngine
import com.google.android.fhir.FhirEngineConfiguration
import com.google.android.fhir.FhirEngineProvider
import com.google.android.fhir.ServerConfiguration
import com.google.android.fhir.sync.remote.HttpLogger

class FhirApplication : Application() {
    //  lazily instantiate an actual FHIR Engine instance
    private val fhirEngine: FhirEngine by lazy { FhirEngineProvider.getInstance(this) }

    override fun onCreate() {
        super.onCreate()

        FhirEngineProvider.init(
            FhirEngineConfiguration(
                enableEncryptionIfSupported = true,
                RECREATE_AT_OPEN,
                ServerConfiguration(
//          baseUrl = "http://10.0.2.2:8080/fhir/",
                    baseUrl = "https://3c8e-102-68-76-201.ngrok-free.app/fhir/",
                    httpLogger =
                    HttpLogger(
                        HttpLogger.Configuration(
                            if (BuildConfig.DEBUG) HttpLogger.Level.BODY else HttpLogger.Level.BASIC
                        )
                    ) { Log.d("App-HttpLog", it) },
                ),
            )
        )
    }

    companion object {
        // convenience method for the rest of the codelab
        fun fhirEngine(context: Context) = (context.applicationContext as FhirApplication).fhirEngine
    }
}