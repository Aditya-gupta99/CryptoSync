package com.sparklead.cryptosync.dto

import kotlinx.serialization.Serializable

@Serializable
data class CryptoListDto(

    val crypto: Map<String, CryptoDetailsDto>
)