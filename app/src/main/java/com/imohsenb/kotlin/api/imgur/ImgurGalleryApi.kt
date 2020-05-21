package com.imohsenb.kotlin.api.imgur

import com.imohsenb.kotlin.model.GalleryModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Imgur Gallery API
 * It uses `https://api.imgur.com/endpoints/gallery` api
 * base url is in `projectRootFolder/config.gradle` file
 *
 * ``https://api.imgur.com/3/gallery/{{section}}/{{sort}}/{{window}}/
 * {{page}}?showViral={{showViral}}&mature={{showMature}}&album_previews={{albumPreviews}}``
 *
 * @author Mohsen Beiranvand
 */
interface ImgurGalleryApi {

    @GET("/3/gallery/{section}/{sort}/{window}/{page}")
    fun get(
        @Path("section") section: String = "hot",
        @Path("sort") sort: String = "viral",
        @Path("page") page: Int = 0,
        @Path("window") window: String = "day",
        @Query("showViral") showViral: Boolean = true
    ): Single<ImgurResponseModel<List<GalleryModel>>>
}