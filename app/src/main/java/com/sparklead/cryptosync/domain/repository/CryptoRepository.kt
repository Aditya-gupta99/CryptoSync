package com.sparklead.cryptosync.domain.repository

import com.sparklead.cryptosync.data.dto.CryptoLiveDto
import com.sparklead.cryptosync.data.dto.CryptoListDto
import com.sparklead.cryptosync.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    suspend fun getAllCurrency(): Flow<CryptoLiveDto>

    suspend fun getListDetails() : Flow<CryptoListDto>

}