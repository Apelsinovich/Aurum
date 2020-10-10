package com.example.myapplication.sql

//TODO решить, как хранить картинки
//TODO решить, как хранить дополнительную информацию о событии (в этой же таблице или сделать отдельную с доступом по ID события)
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
                val DETAILINFO = EventEnum.DETAILINFO.value
                val DATE = EventEnum.DATE.value
                val PLACE = EventEnum.PLACE.value
                val STATUS = EventEnum.STATUS.value
            }
        }
    }
}