package com.example.myapplication.sql

import android.database.Cursor
import android.database.CursorWrapper
import com.example.myapplication.models.Event
import java.util.*

class EventCursorWrapper(cursor: Cursor?) : CursorWrapper(cursor) {

    fun getEvent(): Event? {
        val uuidString = getInt(getColumnIndex(EventDbSchema.EventTable.Cols.UUID))
        val title = getString(getColumnIndex(EventDbSchema.EventTable.Cols.TITLE))
        val info = getString(getColumnIndex(EventDbSchema.EventTable.Cols.INFO))
        val date = getString(getColumnIndex(EventDbSchema.EventTable.Cols.DATE))
        val status = getString(getColumnIndex(EventDbSchema.EventTable.Cols.STATUS))


        //////ондслюрэ

        return Event(id = uuidString , title = title, info = info, detailedInfo = date, actual = status )
    }
}