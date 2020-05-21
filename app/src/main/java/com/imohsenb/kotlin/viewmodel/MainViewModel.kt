package com.imohsenb.kotlin.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.model.State
import com.imohsenb.kotlin.repository.GalleryRepository
import com.imohsenb.kotlin.transformer.observableSchedulersTransformer
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository
) : BaseViewModel() {

    val galleryList: MutableLiveData<List<GalleryModel>> by lazy {
        MutableLiveData<List<GalleryModel>>()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        galleryRepository.getGallery()
            .compose(observableSchedulersTransformer())
            .subscribe({ res ->
                when (res.state) {
                    State.IN_PROGRESS -> toast("Loading...")
                    State.FAILED -> toast(res.message)
                    State.SUCCESS -> galleryList.postValue(res.data)
                }

            }, { throwable ->
                throwable?.printStackTrace()
            })

    }
}