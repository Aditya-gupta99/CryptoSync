package com.sparklead.cryptosync.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val repository: CryptoRepository) : ViewModel() {


    fun getAllCurrency() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAllCurrency()
            .catch {
                Log.e("throwable",it.message.toString())
            }
            .collect{
                Log.e("@@@",it.toString())
            }
    }

    fun getListDetails() = viewModelScope.launch(Dispatchers.IO) {
        repository.getListDetails()
            .catch {
                Log.e("throwable",it.message.toString())
            }
            .collect{
                Log.e("@@@@",it.toString())
            }
    }

}