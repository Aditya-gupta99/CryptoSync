package com.sparklead.cryptosync.usecase

import com.sparklead.cryptosync.dto.CryptoListDto
import com.sparklead.cryptosync.dto.CryptoLiveDto
import com.sparklead.cryptosync.model.Crypto
import com.sparklead.cryptosync.ui.home.CryptoRepository
import com.sparklead.cryptosync.utils.Constants
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