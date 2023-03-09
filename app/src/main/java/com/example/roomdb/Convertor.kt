package com.example.roomdb

import androidx.room.TypeConverter
import java.util.Date

class Convertor {
    @TypeConverter
    fun datetoLong(value: Date):Long{
        return value.time
    }
    @TypeConverter
    fun longtoDate(value: Long):Date{
        return Date(value)
    }

}