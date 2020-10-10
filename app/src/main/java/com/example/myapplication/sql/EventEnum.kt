package com.example.myapplication.sql

enum class EventEnum(val value: String) {
    UUID("uuid"),       //уникальный идентификатор
    TITLE("title"),     //заголовок события
    INFO("info"),       //инормация о событии
    DETAILINFO("detailInfo"),
    DATE("date"),       //дата события
    PLACE("place"),     //место проведения события
    STATUS("actual")    //актуальность события - да/нет
}