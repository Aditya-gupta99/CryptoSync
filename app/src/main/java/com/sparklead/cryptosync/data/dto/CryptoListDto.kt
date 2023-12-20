package com.sparklead.cryptosync.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CryptoListDto(

    val crypto: Map<String, CryptoDetailsDto>
)