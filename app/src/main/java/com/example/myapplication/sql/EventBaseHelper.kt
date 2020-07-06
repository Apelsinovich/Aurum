package com.example.myapplication.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EventBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    //Прочитать про эту магию
    companion object {

    private val DATABASE_VERSION = 1
    private val DATABASE_NAME = "eventBase.db"
}

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table " + EventDbSchema.EventTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                EventDbSchema.EventTable.Cols.UUID + ", " +
                EventDbSchema.EventTable.Cols.TITLE + ", " +
                EventDbSchema.EventTable.Cols.INFO + ", " +
                EventDbSchema.EventTable.Cols.DATE + ", " +
                EventDbSchema.EventTable.Cols.STATUS +
                ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}