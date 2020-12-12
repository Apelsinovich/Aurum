package com.example.aurum_yc.models.clubs

/**
 * Класс события/новости молодежного центра Аурум. Каждый объект такого класса создается динамически в классе EventsFactory
 **/

class Club(

    val UUID: Int,
    var TITLE: String,
    var INFO: String,
    var DETAILINFO: String

    //todo - подумать как реализовать логику дат (+ оповещение что сегодня секция). Проблема - событие происходит несколько дней в неделю, может в разное время
//    var DATE: String

) {}