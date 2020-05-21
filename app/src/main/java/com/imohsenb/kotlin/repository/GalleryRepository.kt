package com.imohsenb.kotlin.repository

import androidx.lifecycle.LiveData
import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.model.ResourceModel

interface GalleryRepository {

    fun getGallery(): LiveData<ResourceModel<List<GalleryModel>>>
}