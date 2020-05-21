package com.imohsenb.kotlin.model

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
    }
}

enum class State {
    IN_PROGRESS,
    SUCCESS,
    FAILED
}