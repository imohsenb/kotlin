package com.imohsenb.kotlin.repository

import com.imohsenb.kotlin.api.imgur.ImgurGalleryApi
import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.transformer.imgurGalleryResponseTransformer
import io.reactivex.Single
import javax.inject.Inject

class ImgurGalleryRepository @Inject constructor(
    private val galleryApi: ImgurGalleryApi
) : GalleryRepository {

    override fun getGallery(): Single<List<GalleryModel>> {
        return galleryApi.get().compose(imgurGalleryResponseTransformer())
    }
}