package com.example.aurum_yc.models.events

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.aurum_yc.db.events.EventBaseHelper
import com.example.aurum_yc.db.events.EventCursorWrapper
import com.example.aurum_yc.db.events.EventDbSchema
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList

/**
 * ����� ���������� � ��������� Event �� �� SQLite.
**/

class EventFactory(context: Context?) {

    private val mContext: Context = context!!.applicationContext
    private val mDataBase: SQLiteDatabase = EventBaseHelper(mContext).writableDatabase

    // ����� �� ������� - ��������� ������� � ������
    fun addEvent(e: Event) {

        val values: ContentValues = getContentValues(e)
        mDataBase.insert(EventDbSchema.EventTable.NAME, null, values)

    }

    // �������� ������� Event �� �� � ������ � ������, � ������� ��������

    fun getEvents(): List<Event> {

        var events: MutableList<Event> = ArrayList()
        var cursor: EventCursorWrapper = queryEvents(null, null)

        cursor.moveToFirst()
//�������� � try catch
        while (!cursor.isAfterLast) {
            val event = cursor.getEvent()!!
            checkEventActuality(event)

            events.add(event)
            cursor.moveToNext()
        }

        cursor.close()
        return events
    }

    //fun getEvent(id: Int): Event? { return null }

    //������ ����������� ��� ������ �������������� �������� ������ ContentValues

    private fun getContentValues(event: Event): ContentValues {

        val values = ContentValues()

        values.put(EventDbSchema.EventTable.Cols.UUID, event.UUID.toString())
        values.put(EventDbSchema.EventTable.Cols.TITLE, event.TITLE)
        values.put(EventDbSchema.EventTable.Cols.INFO, event.INFO)
        values.put(EventDbSchema.EventTable.Cols.DATE, event.DATE)
        values.put(EventDbSchema.EventTable.Cols.PLACE, event.PLACE)
 //       values.put(EventDbSchema.EventTable.Cols.UUID, event.toString())


        return values

    }

    fun updateEvent(event: Event) {
        val uuidString = event.UUID.toString()
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

    fun checkEventActuality(event: Event) {
        event.isActual = System.currentTimeMillis() < event.DATE.toLong()
        convertMillisecondsToReadableDate(event)
    }

    @SuppressLint("SimpleDateFormat")
    fun convertMillisecondsToReadableDate(event: Event){
        val date = event.DATE.toLong()
        val formatExample = SimpleDateFormat("dd.MM.yyyy")
        event.DATE = formatExample.format(date)

    }
}

    //private val mContext: Context = context.applicationContext,
    //val mDataBase: SQLiteDatabase = EventBaseHelper(mCntext).writableDatabase
