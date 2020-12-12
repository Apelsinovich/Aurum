package com.example.aurum_yc.db.events

import com.example.aurum_yc.db.CaptionsHelperEnum

//TODO решить, как хранить картинки
//TODO решить, как хранить дополнительную информацию о событии (в этой же таблице или сделать отдельную с доступом по ID события)
class EventDbSchema {

    class EventTable {
        companion object {
            const val NAME = "events"
    }

        class Cols {
            companion object {
                val UUID = CaptionsHelperEnum.UUID.value
                val TITLE = CaptionsHelperEnum.TITLE.value
                val INFO = CaptionsHelperEnum.INFO.value
                val DETAILINFO = CaptionsHelperEnum.DETAILINFO.value
                val DATE = CaptionsHelperEnum.DATE.value
                val PLACE = CaptionsHelperEnum.PLACE.value
                val STATUS = CaptionsHelperEnum.STATUS.value
            }
        }
    }
}