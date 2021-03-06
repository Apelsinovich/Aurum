package com.example.aurum_yc.db

enum class CaptionsHelperEnum(val value: String) {
    UUID("uuid"),       //уникальный идентификатор
    TITLE("title"),     //заголовок события
    INFO("info"),       //инормация о событии
    DETAILINFO("detailInfo"),
    DATE("date"),       //дата события
    PLACE("place"),     //место проведения события
    STATUS("actual"),    //актуальность события - да/нет

/** Для таблицы с хешами изображений*/

    UUIDOBJECT("uuid_object"),
    TITLEIMAGE("title_image"),
    HASHIMAGE("hash_image")
}