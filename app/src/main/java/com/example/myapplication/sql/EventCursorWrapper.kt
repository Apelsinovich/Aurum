package com.example.myapplication.sql

import android.database.Cursor
import android.database.CursorWrapper
import com.example.myapplication.models.Event
import java.util.*

class EventCursorWrapper(cursor: Cursor?) : CursorWrapper(cursor) {

    fun getEvent(): Event? {
        val uuid = getInt(getColumnIndex(EventDbSchema.EventTable.Cols.UUID.value))
        val title = getString(getColumnIndex(EventDbSchema.EventTable.Cols.TITLE.value))
        val info = getString(getColumnIndex(EventDbSchema.EventTable.Cols.INFO.value))
        val date = getString(getColumnIndex(EventDbSchema.EventTable.Cols.DATE.value))
        val place = getString(getColumnIndex(EventDbSchema.EventTable.Cols.PLACE.value))
        val status = getString(getColumnIndex(EventDbSchema.EventTable.Cols.STATUS.value))

        return Event(
            UUID = uuid,
            TITLE = title,
            INFO = info,
            DATE = date,
            PLACE = place,
            STATUS = status
        )
    }
}