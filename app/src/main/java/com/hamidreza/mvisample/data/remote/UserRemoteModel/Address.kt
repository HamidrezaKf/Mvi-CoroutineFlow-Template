package com.hamidreza.mvisample.data.remote.UserRemoteModel


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String
)