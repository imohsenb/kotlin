package com.imohsenb.kotlin.repository

import com.imohsenb.kotlin.model.GalleryModel
import io.reactivex.Single

interface GalleryRepository {

    fun getGallery(): Single<List<GalleryModel>>
}