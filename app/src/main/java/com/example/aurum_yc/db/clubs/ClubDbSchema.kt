package com.example.aurum_yc.db.clubs

import com.example.aurum_yc.db.CaptionsHelperEnum

//TODO ������, ��� ������� ��������
//TODO ������, ��� ������� �������������� ���������� � ������� (� ���� �� ������� ��� ������� ��������� � �������� �� ID �������)
class ClubDbSchema {

    class ClubTable {
        companion object {
            const val NAME = "clubs"
    }

        class Cols {
            companion object {
                val UUID = CaptionsHelperEnum.UUID.value
                val TITLE = CaptionsHelperEnum.TITLE.value
                val INFO = CaptionsHelperEnum.INFO.value
                val DETAILINFO = CaptionsHelperEnum.DETAILINFO.value
            }
        }
    }

    class ClubImageTable {
        companion object {
            const val NAME = "clubsImage"
        }

        class Cols {
            companion object {
                val UUIDOBJECT = CaptionsHelperEnum.UUIDOBJECT.value
                val TITLEIMAGE = CaptionsHelperEnum.TITLEIMAGE.value
                val HASHIMAGE = CaptionsHelperEnum.HASHIMAGE.value
            }
        }
    }

}