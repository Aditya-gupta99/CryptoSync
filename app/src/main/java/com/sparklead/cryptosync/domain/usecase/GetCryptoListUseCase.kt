package com.sparklead.cryptosync.domain.usecase

import com.sparklead.cryptosync.data.dto.CryptoListDto
import com.sparklead.cryptosync.data.dto.CryptoLiveDto
import com.sparklead.cryptosync.domain.model.Crypto
import com.sparklead.cryptosync.domain.repository.CryptoRepository
import com.sparklead.cryptosync.common.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCryptoListUseCase @Inject constructor(private val repository: CryptoRepository) {

    operator fun invoke(): Flow<List<Crypto>> = flow {
        val cryptoLiveResponseDeferred = withContext(Dispatchers.IO) { async { repository.getAllCurrency() } }
        val cryptoListResponseDeferred = withContext(Dispatchers.IO) { async { repository.getListDetails() } }

        lateinit var cryptoLive: CryptoLiveDto
        lateinit var cryptoList: CryptoListDto

        cryptoLiveResponseDeferred.await().collect {
            cryptoLive = it
        }
        cryptoListResponseDeferred.await().collect {
            cryptoList = it
        }

        emit(Constants.mergeData(cryptoLive, cryptoList))
    }
}