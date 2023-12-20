package com.sparklead.cryptosync.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CryptoDetailsDto(

    val symbol: String,

    val name: String,

    val name_full: String,

    val icon_url: String
)