package com.imohsenb.kotlin.repository

import com.imohsenb.kotlin.api.imgur.ImgurGalleryApi
import com.imohsenb.kotlin.model.GalleryModel
import com.imohsenb.kotlin.model.ResourceModel
import com.imohsenb.kotlin.transformer.imgurGalleryResponseTransformer
import io.reactivex.Observable
import javax.inject.Inject

class ImgurGalleryRepository @Inject constructor(
    private val galleryApi: ImgurGalleryApi
) : GalleryRepository {

    override fun getGallery(): Observable<ResourceModel<List<GalleryModel>>> {
        return Observable.create { emitter ->
            emitter.onNext(ResourceModel.loading())
            galleryApi.get().compose(imgurGalleryResponseTransformer())
                .subscribe { data, throwable ->
                    data?.let {
                        emitter.onNext(ResourceModel.success(data))
                    }
                    throwable?.let {
                        emitter.onNext(ResourceModel.failed(it.message))
                    }
                    emitter.onComplete()
                }
        }
    }
}