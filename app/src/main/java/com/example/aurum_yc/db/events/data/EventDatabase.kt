package com.example.aurum_yc.db.events.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//https://www.youtube.com/watch?v=lwAvI3WDXBY&ab_channel=Stevdza-San 10minute
@Database(entities = [Event::class], version = 1, exportSchema = false) // прочитать про false/true и версии
abstract class EventDatabase: RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object{

        @Volatile
        private var INSTANCE: EventDatabase? = null

        fun getDataBase(context: Context): EventDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EventDatabase::class.java,
                    "event_database")
                    .createFromAsset("event_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}