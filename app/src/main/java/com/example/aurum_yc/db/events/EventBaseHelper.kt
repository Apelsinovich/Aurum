package com.example.aurum_yc.db.events

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//TODO дописать логику - update
//TODO решить как загружать предзаполненную бд при установке приложения на физическом девайсе
//TODO БОЛЬШАЯ ЗАДАЧА - реализовать синхронизацию с БД на сервере, где Серега через web интерфейс будет добавлять события центра
//TODO что по геолокации?

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
                EventDbSchema.EventTable.Cols.DETAILINFO + ", " +
                EventDbSchema.EventTable.Cols.DATE + ", " +
                EventDbSchema.EventTable.Cols.PLACE + ", " +
                EventDbSchema.EventTable.Cols.STATUS +
                ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}