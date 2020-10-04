package com.example.myapplication.sql

//????? ??
class EventDbSchema {

    class EventTable {
        companion object {
            const val NAME = "events"
    }

        class Cols {
            companion object {
                val UUID = EventEnum.UUID
                val TITLE = EventEnum.TITLE
                val INFO = EventEnum.INFO
                val DATE = EventEnum.DATE
                val PLACE = EventEnum.PLACE
                val STATUS = EventEnum.STATUS
            }
        }
    }
}