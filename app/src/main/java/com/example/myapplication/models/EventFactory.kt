package com.example.myapplication.models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.myapplication.sql.EventBaseHelper
import com.example.myapplication.sql.EventCursorWrapper
import com.example.myapplication.sql.EventDbSchema

class EventFactory(context: Context?) {

    private val mContext: Context = context!!.applicationContext
    private val mDataBase: SQLiteDatabase = EventBaseHelper(mContext).writableDatabase

    fun addEvent(e: Event) {

        val values: ContentValues = getContentValues(e)
        mDataBase.insert(EventDbSchema.EventTable.NAME, null, values)

    }

    fun getEvents(): List<Event> {
        
        var events: MutableList<Event> = ArrayList()
        var cursor: EventCursorWrapper = queryEvents(null, null)

        cursor.moveToFirst()
//обернуть в try catch
        while (!cursor.isAfterLast) {
            events.add(cursor.getEvent()!!)
            cursor.moveToNext()
        }

        cursor.close()
        return events
    }

    fun getEvent(id: Int): Event? { return null }

    //Запись иобновление баз данных осуществляются спомощью класса ContentValues

    private fun getContentValues(event: Event): ContentValues {

        val values: ContentValues = ContentValues()

        values.put(EventDbSchema.EventTable.Cols.UUID, event.id.toString())
        values.put(EventDbSchema.EventTable.Cols.TITLE, event.title)
        values.put(EventDbSchema.EventTable.Cols.INFO, event.info)
        values.put(EventDbSchema.EventTable.Cols.DATE, event.detailedInfo)
        values.put(EventDbSchema.EventTable.Cols.UUID, event.toString())

        return values

    }

    fun updateEvent(event: Event) {
        val uuidString = event.id.toString()
        val values: ContentValues = getContentValues(event)

        mDataBase.update(
            EventDbSchema.EventTable.NAME, values,
            EventDbSchema.EventTable.Cols.UUID + " = ?", arrayOf(uuidString)
        )
    }

    fun queryEvents(whereClause: String?, whereArgs: Array<String>?) : EventCursorWrapper {
        val cursor: Cursor = mDataBase.query(
            EventDbSchema.EventTable.NAME,
            null,
            whereClause,
            whereArgs,
            null,
            null,
            null
        )
        return EventCursorWrapper(cursor)
    }

}

    //private val mContext: Context = context.applicationContext,
    //val mDataBase: SQLiteDatabase = EventBaseHelper(mCntext).writableDatabase
