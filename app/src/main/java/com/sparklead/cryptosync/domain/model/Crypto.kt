package com.sparklead.cryptosync.domain.model

data class Crypto(

    val symbol: String,

    val fullName: String,

    val icon: String,

    val exchange: Double
)