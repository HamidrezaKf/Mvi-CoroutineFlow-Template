package com.hamidreza.mvisample.data.remote.UserRemoteModel


import com.google.gson.annotations.SerializedName

data class UserRemoteEntity(
    @SerializedName("address")
    val address: Address,
    @SerializedName("company")
    val company: Company,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String
)