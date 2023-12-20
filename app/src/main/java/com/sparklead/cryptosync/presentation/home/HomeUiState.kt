package com.sparklead.cryptosync.presentation.home

import com.sparklead.cryptosync.domain.model.Crypto

sealed class HomeUiState {

    data object Empty : HomeUiState()

    data object Loading : HomeUiState()

    data class Success(val cryptoList: List<Crypto>) : HomeUiState()

    data class Error(val message: String) : HomeUiState()

}