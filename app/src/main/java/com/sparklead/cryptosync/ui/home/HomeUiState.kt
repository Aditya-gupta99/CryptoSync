package com.sparklead.cryptosync.ui.home

import com.sparklead.cryptosync.model.Crypto

sealed class HomeUiState {

    data object Empty : HomeUiState()

    data object Loading : HomeUiState()

    data class Success(val cryptoList: List<Crypto>) : HomeUiState()

    data class Error(val message: String) : HomeUiState()

}