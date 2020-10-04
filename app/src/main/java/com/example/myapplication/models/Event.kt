package com.example.myapplication.models

import android.graphics.drawable.Drawable
import com.example.myapplication.sql.EventDbSchema
import com.example.myapplication.sql.EventEnum
import java.util.*

/***
 * Класс события/новости молодежного центра Аурум. Каждый объект такого класса создается динамически в классе EventsFactory
 *
 ***/

class Event(

    val UUID: Int,                       //рандомный уникальынй ID события
    var TITLE: String,                  //Заголовок новости/события
    var INFO: String,           //Более полная информация о событии, которая изначально скрыта. По кнопке можно раскрыть в том же окне.
    var DATE: String,                   //Мини информация под заголовком о событии
    //var image: Drawable?,             //Фотография события
    var expanded: Boolean = false,      //Флаг означающий что подробная информация expandableInfo скрыта по умолчанию
    var PLACE: String,                  //Место проведения события
    var STATUS: String  = "1"         //Актуально ли событие, если дата события раньше текуще, то событие неактуально

) {}