package com.sparklead.cryptosync.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sparklead.cryptosync.usecase.GetCryptoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val useCase: GetCryptoListUseCase) : ViewModel() {

    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Empty)
    val homeUiState = _homeUiState.asStateFlow()


    fun getCryptoList() = viewModelScope.launch(Dispatchers.IO) {
        useCase()
            .catch {
                _homeUiState.value = HomeUiState.Error(it.message.toString())
            }
            .collect{
                _homeUiState.value = HomeUiState.Success(it)
            }
    }
}