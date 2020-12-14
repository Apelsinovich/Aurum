package com.example.aurum_yc.db.events.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import java.lang.Appendable

public class EventViewModel(application: Application): AndroidViewModel(application) {

    public val readAllData: LiveData<List<Event>>
    private val repository: EventRepository

    init {
        val eventDao = EventDatabase.getDataBase(application).eventDao()
        repository = EventRepository(eventDao)
        readAllData = repository.readAllData
    }

    fun addEvent(event: Event) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEvent(event)
        }
    }

}