package com.imohsenb.kotlin.di.module

import androidx.lifecycle.ViewModel
import com.imohsenb.kotlin.di.annotation.ViewModelKey
import com.imohsenb.kotlin.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel
}