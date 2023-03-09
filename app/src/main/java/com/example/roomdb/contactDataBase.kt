package com.example.roomdb

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertor::class)
abstract class contactDataBase:RoomDatabase() {
    abstract fun contactDAO():ContactDao

    companion object{
        val migration_1_2=object :Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile//db change hoga tho sare therad ko pata pad jayega
        private var instance:contactDataBase?=null

        fun getDB(context:Context):contactDataBase{
            if(instance==null){
                synchronized(this){//IT is lock ,that does not create multiple instance.
                    instance=Room.databaseBuilder(context.applicationContext,
                        contactDataBase::class.java,
                        "contactDB").addMigrations(migration_1_2).build()
                }
            }
            return instance!!
        }
    }
}



