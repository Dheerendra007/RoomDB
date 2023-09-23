package com.dk.roomdb

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import com.dk.roomdb.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    lateinit var database: UserDatabase
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        database = UserDatabase.getDatabase(this)
        GlobalScope.launch {
            database.userDataDao().insertUserData(UserData(0,"IROM MAN","90909090"))
        }
    }

    fun updateData(v:View){
            database.userDataDao().getUserData().observe(this, Observer {

            })
    }
}