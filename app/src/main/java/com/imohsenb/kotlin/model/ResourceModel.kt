package com.imohsenb.kotlin.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

data class ResourceModel<out T>(
    val data: T? = null,
    val state: State = State.FAILED,
    val message: String? = null
) {
    companion object {
        fun <T> loading(): ResourceModel<T> = ResourceModel(state = State.IN_PROGRESS)

        fun <T> failed(message: String?): ResourceModel<T> =
            ResourceModel(message = message)

        fun <T> success(data: T): ResourceModel<T> =
            ResourceModel(data = data, state = State.SUCCESS)

        fun <T> call(cb: suspend () -> T): LiveData<ResourceModel<T>> {
            return liveData(Dispatchers.IO) {
                emit(loading())
                try {
                    emit(success(cb()))
                } catch (e: Exception) {
                    emit(failed<T>(e.message))
                }
            }
        }
    }
}

enum class State {
    IN_PROGRESS,
    SUCCESS,
    FAILED
}

