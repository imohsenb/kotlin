package com.imohsenb.kotlin.model

/**
 * GalleryModel data model
 * @author Mohsen Beiranvand
 */
data class GalleryModel(
    val id: String?,
    val title: String?,
    val description: String?,
    val images: List<ImageModel>?
)