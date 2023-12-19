package com.sparklead.cryptosync.utils

import com.sparklead.cryptosync.dto.CryptoListDto
import com.sparklead.cryptosync.dto.CryptoLiveDto
import com.sparklead.cryptosync.model.Crypto

object Constants {

    const val API_KEY = "692614f6d7b2680094e6979ec44df40c"


    fun mergeData(
        cryptoLive: CryptoLiveDto,
        cryptoList: CryptoListDto
    ): List<Crypto> {

        val mergedList = mutableListOf<Crypto>()

        cryptoList.crypto.forEach { (symbol, cryptoDetailsDto) ->
            cryptoLive.rates[symbol]?.let { exchangeRate ->

                val crypto = Crypto(
                    symbol = symbol,
                    fullName = cryptoDetailsDto.name_full,
                    icon = cryptoDetailsDto.icon_url,
                    exchange = exchangeRate
                )
                mergedList.add(crypto)
            }
        }
        return mergedList
    }

}