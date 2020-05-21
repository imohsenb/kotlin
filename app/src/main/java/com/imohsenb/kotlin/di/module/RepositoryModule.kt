package com.imohsenb.kotlin.di.module

import com.imohsenb.kotlin.repository.GalleryRepository
import com.imohsenb.kotlin.repository.ImgurGalleryRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsImgurGalleryRepository(repository: ImgurGalleryRepository): GalleryRepository
}