package com.hamidreza.mvisample.data.remote.UserRemoteModel


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("name")
    val name: String
)