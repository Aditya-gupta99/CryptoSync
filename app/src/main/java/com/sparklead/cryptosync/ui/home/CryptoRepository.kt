package com.sparklead.cryptosync.ui.home

import com.sparklead.cryptosync.dto.CryptoItem
import com.sparklead.cryptosync.dto.CryptoListDto
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {

    suspend fun getAllCurrency(): Flow<CryptoItem>

    suspend fun getListDetails() : Flow<CryptoListDto>
}