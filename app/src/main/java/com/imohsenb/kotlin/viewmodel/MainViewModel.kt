
package com.imohsenb.kotlin.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.imohsenb.kotlin.repository.GalleryRepository
import com.imohsenb.kotlin.transformer.schedulersTransformer
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository
) : ViewModel() {

    @SuppressLint("CheckResult")
    fun loadData() {
        galleryRepository.getGallery()
            .compose(schedulersTransformer())
            .subscribe { data, throwable ->
                throwable?.printStackTrace()
            }
    }
}