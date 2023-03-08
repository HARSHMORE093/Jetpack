package com.example.demoapplication

import androidx.lifecycle.ViewModel

class ActivityViewModel:ViewModel() {
    private var count=0
    fun Total():Int{
        return count
    }
    fun updateTotal(Input:Int){
        count+=Input
    }
}