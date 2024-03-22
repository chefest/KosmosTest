package com.chefsito.kosmostest.di.coroutinedispatchers

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class CoroutineDispatcherModule {
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}