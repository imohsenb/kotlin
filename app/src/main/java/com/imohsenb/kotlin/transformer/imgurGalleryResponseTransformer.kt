package com.imohsenb.kotlin.transformer

import com.imohsenb.kotlin.api.imgur.ImgurResponseModel
import com.imohsenb.kotlin.model.GalleryModel
import io.reactivex.SingleTransformer

/**
 * Imgur Gallery Response Transformer
 * it's a RxJava transformer function for composing source Single
 * to transform incompatible data type to required data type by repository
 * @author Mohsen Beiranvand
 */
fun imgurGalleryResponseTransformer():
        SingleTransformer<ImgurResponseModel<List<GalleryModel>>, List<GalleryModel>> {
    return SingleTransformer { result ->
        result.map {
            when (it.success) {
                true -> it.data
                false -> listOf()
            }
        }
    }
}