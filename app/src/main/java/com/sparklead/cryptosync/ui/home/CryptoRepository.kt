package com.sparklead.cryptosync.ui.home

import com.sparklead.cryptosync.dto.CryptoLiveDto
import com.sparklead.cryptosync.dto.CryptoListDto
import com.sparklead.cryptosync.model.Crypto
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    suspend fun getAllCurrency(): Flow<CryptoLiveDto>

    suspend fun getListDetails() : Flow<CryptoListDto>

//    suspend fun getCryptoData() : Flow<List<Crypto>>
}