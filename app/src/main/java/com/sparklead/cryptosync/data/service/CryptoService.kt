package com.sparklead.cryptosync.data.service

import com.sparklead.cryptosync.data.dto.CryptoLiveDto
import com.sparklead.cryptosync.data.dto.CryptoListDto

interface CryptoService {

    suspend fun getAllCurrencies() : CryptoLiveDto

    suspend fun getCompletedCurrenciesDetail() : CryptoListDto
}