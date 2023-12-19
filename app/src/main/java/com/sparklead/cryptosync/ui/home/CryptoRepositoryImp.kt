package com.sparklead.cryptosync.ui.home

import com.sparklead.cryptosync.dto.CryptoListDto
import com.sparklead.cryptosync.dto.CryptoLiveDto
import com.sparklead.cryptosync.service.CryptoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoRepositoryImp @Inject constructor(private val serviceImp: CryptoService) :
    CryptoRepository {

    override suspend fun getAllCurrency(): Flow<CryptoLiveDto> {
        return flow {
            emit(serviceImp.getAllCurrencies())
        }
    }

    override suspend fun getListDetails(): Flow<CryptoListDto> {
        return flow {
            emit(serviceImp.getCompletedCurrenciesDetail())
        }
    }
}