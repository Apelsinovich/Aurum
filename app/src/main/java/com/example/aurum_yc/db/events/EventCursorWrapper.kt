package com.example.aurum_yc.db.events

import android.database.Cursor
import android.database.CursorWrapper
import com.example.aurum_yc.db.events.data.Event

class EventCursorWrapper(cursor: Cursor?) : CursorWrapper(cursor) {

    fun getEvent(): Event? {
        val uuid = getInt(getColumnIndex(EventDbSchema.EventTable.Cols.UUID))
        val title = getString(getColumnIndex(EventDbSchema.EventTable.Cols.TITLE))
        val info = getString(getColumnIndex(EventDbSchema.EventTable.Cols.INFO))
        val detailInfo = getString(getColumnIndex(EventDbSchema.EventTable.Cols.DETAILINFO))
        val date = getString(getColumnIndex(EventDbSchema.EventTable.Cols.DATE))
        val place = getString(getColumnIndex(EventDbSchema.EventTable.Cols.PLACE))
        //val status = getString(getColumnIndex(EventDbSchema.EventTable.Cols.STATUS))

        return Event(
            UUID = uuid,
            TITLE = title,
            INFO = info,
            DETAILINFO = detailInfo,
            DATE = date,
            PLACE = place
        )
    }
}