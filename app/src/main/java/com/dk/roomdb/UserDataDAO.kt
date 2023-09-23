package com.dk.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDataDAO {

    @Insert
    suspend fun insertUserData(userData: UserData)// suspend execute in background thread

    @Update
    suspend fun updateUserData(userData: UserData)

    @Delete
    suspend fun deleteUserData(userData: UserData)

    @Query("SELECT * FROM userdata")
    fun getUserData(): LiveData<List<UserData>>
}