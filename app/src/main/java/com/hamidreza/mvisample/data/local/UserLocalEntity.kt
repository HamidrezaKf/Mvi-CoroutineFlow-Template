package com.hamidreza.mvisample.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserLocalEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val email: String,
    val name: String,
    val phone: String,
    val city: String,
    val companyName:String
) {
}