package com.example.livedataandviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    val quote=MutableLiveData<String>("Hello world?")
    fun update(){
        quote.value="My Name is Harsh More"
    }
}