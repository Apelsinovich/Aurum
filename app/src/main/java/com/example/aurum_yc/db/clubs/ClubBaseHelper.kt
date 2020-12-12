package com.example.aurum_yc.db.clubs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aurum_yc.db.clubs.ClubDbSchema.ClubImageTable.Companion.NAME

//TODO дописать логику - update
//TODO решить как загружать предзаполненную бд при установке приложения на физическом девайсе
//TODO БОЛЬШАЯ ЗАДАЧА - реализовать синхронизацию с БД на сервере, где Серега через web интерфейс будет добавлять секции центра
//TODO что по геолокации?

class ClubBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    //Прочитать про эту магию
    companion object {

    private val DATABASE_VERSION = 1
    private val DATABASE_NAME = "clubBase.db"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        // Таблица для хранения информации о секции

        db?.execSQL("create table " + ClubDbSchema.ClubTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                ClubDbSchema.ClubTable.Cols.UUID + ", " +
                ClubDbSchema.ClubTable.Cols.TITLE + ", " +
                ClubDbSchema.ClubTable.Cols.INFO + ", " +
                ClubDbSchema.ClubTable.Cols.DETAILINFO +
                ")"
        )

        // Таблица для хранения изображений

        db?.execSQL("create table " + NAME + "(" +
                " _id integer primary key autoincrement, " +
                ClubDbSchema.ClubImageTable.Cols.UUIDOBJECT + ", " +
                ClubDbSchema.ClubImageTable.Cols.TITLEIMAGE + ", " +
                ClubDbSchema.ClubImageTable.Cols.HASHIMAGE +
                ")"
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}