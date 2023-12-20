package com.sparklead.cryptosync.di

import com.sparklead.cryptosync.data.service.CryptoService
import com.sparklead.cryptosync.domain.repository.CryptoRepository
import com.sparklead.cryptosync.data.repositoryImp.CryptoRepositoryImp
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