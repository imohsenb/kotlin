package com.imohsenb.kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    val toastMessage: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }

    fun toast(message: String?) {
        toastMessage.postValue(message)
    }
}