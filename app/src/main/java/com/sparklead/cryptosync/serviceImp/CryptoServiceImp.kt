package com.sparklead.cryptosync.serviceImp

import android.util.Log
import com.sparklead.cryptosync.dto.CryptoLiveDto
import com.sparklead.cryptosync.dto.CryptoListDto
import com.sparklead.cryptosync.remote.HttpRoutes
import com.sparklead.cryptosync.service.CryptoService
import com.sparklead.cryptosync.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class CryptoServiceImp @Inject constructor(private val client: HttpClient) : CryptoService {

    override suspend fun getAllCurrencies(): CryptoLiveDto {
        return try {
            client.get {
                url(HttpRoutes.LiveCurrency)
                parameter("access_key", Constants.API_KEY)
                contentType(ContentType.Application.Json)
            }
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            throw e
        }
    }

    override suspend fun getCompletedCurrenciesDetail(): CryptoListDto {
        return try {
            client.get {
                url(HttpRoutes.ListDetails)
                parameter("access_key", Constants.API_KEY)
                contentType(ContentType.Application.Json)
            }
        } catch (e: Exception) {
            Log.e("Exception", e.message.toString())
            throw e
        }
    }
}