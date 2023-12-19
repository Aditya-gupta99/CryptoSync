package com.sparklead.cryptosync.service

import com.sparklead.cryptosync.dto.CryptoItem
import com.sparklead.cryptosync.dto.CryptoListDto

interface CryptoService {

    suspend fun getAllCurrencies() : CryptoItem

    suspend fun getCompletedCurrenciesDetail() : CryptoListDto
}