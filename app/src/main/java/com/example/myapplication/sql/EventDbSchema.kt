package com.example.myapplication.sql

//????? ??
class EventDbSchema {

    class EventTable {
        companion object {
            const val NAME = "events"
    }

        class Cols {
            companion object {
                val UUID = EventEnum.UUID.value
                val TITLE = EventEnum.TITLE.value
                val INFO = EventEnum.INFO.value
                val DATE = EventEnum.DATE.value
                val PLACE = EventEnum.PLACE.value
                val STATUS = EventEnum.STATUS.value
            }
        }
    }
}