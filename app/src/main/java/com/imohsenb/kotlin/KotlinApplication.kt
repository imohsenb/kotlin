package com.imohsenb.kotlin

import com.imohsenb.kotlin.di.component.AppComponent
import com.imohsenb.kotlin.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


/**
 * Kotlin Application.
 * It's necessary for dagger injection
 */
class KotlinApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //Build app component
        val appComponent: AppComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        //inject application instance
        appComponent.inject(this)
        return appComponent
    }
}