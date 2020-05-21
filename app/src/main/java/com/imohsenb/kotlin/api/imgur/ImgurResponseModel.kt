package com.imohsenb.kotlin.api.imgur

data class ImgurResponseModel<T>(
    val data: T,
    val success: Boolean,
    val status: Int
)