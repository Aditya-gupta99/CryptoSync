package com.sparklead.cryptosync.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CryptoLiveDto(

    val privacy: String,

    val rates: Map<String,Double>,

    val success: Boolean,

    val target: String,

    val terms: String,

    val timestamp: Int
)