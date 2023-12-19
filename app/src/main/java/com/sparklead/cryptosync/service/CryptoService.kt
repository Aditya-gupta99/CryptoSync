package com.sparklead.cryptosync.service

import com.sparklead.cryptosync.dto.CryptoLiveDto
import com.sparklead.cryptosync.dto.CryptoListDto

interface CryptoService {

    suspend fun getAllCurrencies() : CryptoLiveDto

    suspend fun getCompletedCurrenciesDetail() : CryptoListDto
}