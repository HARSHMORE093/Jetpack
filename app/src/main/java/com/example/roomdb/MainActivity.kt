package com.example.roomdb


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var db:contactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db=contactDataBase.getDB(this)
        GlobalScope.launch{
            db.contactDAO().insertContact(Contact(0,"Harsh","830", Date(),1))
        }
    }

    fun get(view: View) {
        db.contactDAO().getContact().observe(this, Observer {
            Log.d("Harsh",it.toString())
        })
    }
}




