package com.example.aurum_yc.db.clubs

import android.database.Cursor
import android.database.CursorWrapper
import com.example.aurum_yc.models.clubs.Club

/** TODO подумать как выдернуть массив картинок из второй табоицы и запихнуть в объект*/

class ClubCursorWrapper(cursor: Cursor?) : CursorWrapper(cursor) {

    fun getClub(): Club? {
        val uuid = getInt(getColumnIndex(ClubDbSchema.ClubTable.Cols.UUID))
        val title = getString(getColumnIndex(ClubDbSchema.ClubTable.Cols.TITLE))
        val info = getString(getColumnIndex(ClubDbSchema.ClubTable.Cols.INFO))
        val detailInfo = getString(getColumnIndex(ClubDbSchema.ClubTable.Cols.DETAILINFO))



        return Club(
            UUID = uuid,
            TITLE = title,
            INFO = info,
            DETAILINFO = detailInfo
        )
    }
}