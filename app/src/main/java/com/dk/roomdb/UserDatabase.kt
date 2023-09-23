package com.dk.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDataDao(): UserDataDAO

    companion object{
        @Volatile //Any value update INSTANCE then it's available all threads
        private var INSTANCE:UserDatabase? = null

        fun getDatabase(context:Context): UserDatabase{
            if(INSTANCE==null) {
                synchronized(this) { // Single instance created
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, UserDatabase::class.java,
                    "userdata"
                ).build()
            }
            }
            return INSTANCE!!
        }
    }
}