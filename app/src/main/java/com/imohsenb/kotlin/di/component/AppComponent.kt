package com.imohsenb.kotlin.di.component

import android.app.Application
import com.imohsenb.kotlin.KotlinApplication
import com.imohsenb.kotlin.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        ApiModule::class
    ]
)
interface AppComponent : AndroidInjector<KotlinApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: KotlinApplication?)
}