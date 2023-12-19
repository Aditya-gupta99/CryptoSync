package com.sparklead.cryptosync.di

import com.sparklead.cryptosync.service.CryptoService
import com.sparklead.cryptosync.ui.home.CryptoRepository
import com.sparklead.cryptosync.ui.home.CryptoRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCryptoRepository(service: CryptoService) : CryptoRepository = CryptoRepositoryImp(service)
}