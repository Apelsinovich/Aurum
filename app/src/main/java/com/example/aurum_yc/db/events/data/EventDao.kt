package com.example.aurum_yc.db.events.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEvent(event: Event)

    @Query("SELECT * FROM events_table")
    fun readAllData(): LiveData<List<Event>>
}