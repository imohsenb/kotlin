package com.imohsenb.kotlin.repository

import androidx.lifecycle.LiveData
import com.imohsenb.kotlin.api.imgur.ImgurGalleryApi
import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.model.ResourceModel
import javax.inject.Inject

class ImgurGalleryRepository @Inject constructor(
    private val galleryApi: ImgurGalleryApi
) : GalleryRepository {

    override fun getGallery(): LiveData<ResourceModel<List<GalleryModel>>> {
        return ResourceModel.call {
            galleryApi.get().data
        }
    }
}