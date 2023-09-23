package com.dk.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userdata")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val userName: String,
    val userMobileNumber: String
)
