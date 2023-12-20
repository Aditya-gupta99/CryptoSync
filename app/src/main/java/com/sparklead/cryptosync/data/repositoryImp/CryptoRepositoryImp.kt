package com.sparklead.cryptosync.data.repositoryImp

import com.sparklead.cryptosync.domain.repository.CryptoRepository
import com.sparklead.cryptosync.data.dto.CryptoListDto
import com.sparklead.cryptosync.data.dto.CryptoLiveDto
import com.sparklead.cryptosync.data.service.CryptoService
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