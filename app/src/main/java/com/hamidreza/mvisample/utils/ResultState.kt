package com.hamidreza.mvisample.utils

sealed class ResultState<out R>{
    object Loading : ResultState<Nothing>()
    data class Success<T>(val data:T) : ResultState<T>()
    data class Error(val msg: String) : ResultState<Nothing>()
}
