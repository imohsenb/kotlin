package com.imohsenb.kotlin.transformer

import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Schedulers Transformer
 * it's a RxJava transformer function for composing source Single
 * and apply specific schedulers.
 * @author Mohsen Beiranvand
 */
fun <T> singleSchedulersTransformer(): SingleTransformer<T, T> {
    return SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T> observableSchedulersTransformer(): ObservableTransformer<T, T> {
    return ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}