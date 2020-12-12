package com.example.aurum_yc.models.clubs

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.aurum_yc.db.clubs.ClubBaseHelper
import com.example.aurum_yc.db.clubs.ClubCursorWrapper
import com.example.aurum_yc.db.clubs.ClubDbSchema

class ClubFactory(context: Context?) {
    private val mContext: Context = context!!.applicationContext
    private val mDataBase: SQLiteDatabase = ClubBaseHelper(mContext).writableDatabase

    // получить события Event из БД и запись в массив, с которым работаем

    fun getClubs(): List<Club> {

        var clubs: MutableList<Club> = ArrayList()
        var cursor: ClubCursorWrapper = queryClubs(null, null)

        cursor.moveToFirst()
//обернуть в try catch
        while (!cursor.isAfterLast) {
            val club = cursor.getClub()!!


            clubs.add(club)
            cursor.moveToNext()
        }
        cursor.close()
        return clubs
    }

    //fun getEvent(id: Int): Event? { return null }

    //Запись иобновление баз данных осуществляются спомощью класса ContentValues

    private fun getContentValues(club: Club): ContentValues {

        val values = ContentValues()

        values.put(ClubDbSchema.ClubTable.Cols.UUID, club.UUID.toString())
        values.put(ClubDbSchema.ClubTable.Cols.TITLE, club.TITLE)
        values.put(ClubDbSchema.ClubTable.Cols.INFO, club.INFO)
//        values.put(ClubDbSchema.ClubTable.Cols.DATE, club.DATE)
//        values.put(ClubDbSchema.ClubTable.Cols.PLACE, club.PLACE)
//        values.put(EventDbSchema.EventTable.Cols.UUID, event.toString())


        return values
    }

    fun updateEvent(club: Club) {
        val uuidString = club.UUID.toString()
        val values: ContentValues = getContentValues(club)

        mDataBase.update(
            ClubDbSchema.ClubTable.NAME, values,
            ClubDbSchema.ClubTable.Cols.UUID + " = ?", arrayOf(uuidString)
        )
    }

    fun queryClubs(whereClause: String?, whereArgs: Array<String>?): ClubCursorWrapper {
        val cursor: Cursor = mDataBase.query(
            ClubDbSchema.ClubTable.NAME,
            null,
            whereClause,
            whereArgs,
            null,
            null,
            null
        )
        return ClubCursorWrapper(cursor)
    }

//    fun checkCLubsActuality(club: Club) {
//        club.isActual = System.currentTimeMillis() < club.DATE.toLong()
//        convertMillisecondsToReadableDate(club)
//    }

//    @SuppressLint("SimpleDateFormat")
//    fun convertMillisecondsToReadableDate(club: Club){
//        val date = club.DATE.toLong()
//        val formatExample = SimpleDateFormat("dd.MM.yyyy")
//        club.DATE = formatExample.format(date)
//
//    }
}
