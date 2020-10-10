package com.example.myapplication.models

import android.graphics.drawable.Drawable
import com.example.myapplication.sql.EventDbSchema
import com.example.myapplication.sql.EventEnum
import java.util.*
import java.util.logging.LogManager

/***
 * Класс события/новости молодежного центра Аурум. Каждый объект такого класса создается динамически в классе EventsFactory
 ***/

class Event(

    val UUID: Int,                       //рандомный уникальынй ID события
    var TITLE: String,                  //Заголовок новости/события
    var INFO: String,                   //Более полная информация о событии, которая изначально скрыта. По кнопке можно раскрыть в том же окне.
    var DETAILINFO: String,
    var DATE: String,                   //Мини информация под заголовком о событии
    //TODO реализовать логику подгрузки изображения к событию. Решить. как хранить в БД информацию о картинке, хеш не хеш
    //var image: Drawable?,             //Фотография события
    var expanded: Boolean = false,      //Флаг означающий что подробная информация expandableInfo скрыта по умолчанию
    var PLACE: String,                  //Место проведения события
    var isActual: Boolean = true         //Актуально ли событие, если дата события раньше текуще, то событие неактуально

) {}