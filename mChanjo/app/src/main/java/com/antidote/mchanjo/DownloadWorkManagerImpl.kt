package com.antidote.mchanjo

import com.google.android.fhir.sync.DownloadWorkManager
import com.google.android.fhir.sync.Request
import org.hl7.fhir.r4.model.Bundle
import org.hl7.fhir.r4.model.Resource
import org.hl7.fhir.r4.model.ResourceType
import java.util.LinkedList

class DownloadWorkManagerImpl: DownloadWorkManager {
    private val urls = LinkedList(listOf("Patient"))

    override suspend fun getNextRequest(): Request? {
        val url = urls.poll() ?: return null
        return Request.of(url)
    }

    override suspend fun getSummaryRequestUrls() = mapOf<ResourceType, String>()
//    override suspend fun getSummaryRequestUrls(): Map<ResourceType, String> {
//        TODO("Not yet implemented")
//    }

    override suspend fun processResponse(response: Resource): Collection<Resource> {
        var bundleCollection: Collection<Resource> = mutableListOf()
        if (response is Bundle && response.type == Bundle.BundleType.SEARCHSET) {
            bundleCollection = response.entry.map { it.resource }
        }
        return bundleCollection
    }
}