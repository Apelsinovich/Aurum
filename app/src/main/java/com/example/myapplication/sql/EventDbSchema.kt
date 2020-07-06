package com.example.myapplication.sql

//Схема БД
class EventDbSchema {

    class EventTable {
        companion object {
            const val NAME = "events"
    }

        class Cols {
            companion object {
                const val UUID = "uuid"         //id
                const val TITLE = "title"       //title
                const val INFO = "info"         //info
                const val DATE = "date"         //detailtInfo временно
                const val STATUS = "actual"     //actual actual
            }
        }
    }
}