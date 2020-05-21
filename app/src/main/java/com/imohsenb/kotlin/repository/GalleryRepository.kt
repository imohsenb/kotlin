package com.imohsenb.kotlin.repository

import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.model.ResourceModel
import io.reactivex.Observable

interface GalleryRepository {

    fun getGallery(): Observable<ResourceModel<List<GalleryModel>>>
}