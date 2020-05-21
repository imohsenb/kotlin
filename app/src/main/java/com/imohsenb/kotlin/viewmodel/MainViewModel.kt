
package com.imohsenb.kotlin.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.repository.GalleryRepository
import com.imohsenb.kotlin.transformer.schedulersTransformer
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository
) : ViewModel() {

    val galleryList: MutableLiveData<List<GalleryModel>> by lazy {
        MutableLiveData()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        galleryRepository.getGallery()
            .compose(schedulersTransformer())
            .subscribe { data, throwable ->
                data?.let {
                    galleryList.postValue(it)
                }
                throwable?.printStackTrace()
            }
    }
}