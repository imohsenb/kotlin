package com.imohsenb.kotlin.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.imohsenb.kotlin.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}