package com.sparklead.cryptosync.dto

import kotlinx.serialization.Serializable

@Serializable
data class CryptoItem(

    val privacy: String,

    val rates: Map<String,Double>,

    val success: Boolean,

    val target: String,

    val terms: String,

    val timestamp: Int
)