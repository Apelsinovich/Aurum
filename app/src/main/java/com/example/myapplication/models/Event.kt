package com.example.myapplication.models

import android.graphics.drawable.Drawable
import java.util.*

/***
 * Класс события/новости молодежного центра Аурум. Каждый объект такого класса создается динамически
 ***/

class Event(

    val id: Int,                       //рандомный уникальынй ID события
    var title: String,                  //Заголовок новости/события
    var info: String,                   //Мини информация под заголовком о событии
    // var date: Int,                   //Дата события, на данный момент это id картинки (для теста). В планах подгружать динмаичски картинку-дату
    //var image: Drawable?,             //Фотография события
    var detailedInfo: String,           //Более полная информация о событии, которая изначально скрыта. По кнопке можно раскрыть в том же окне.
    var expanded: Boolean = false,      //Флаг означающий что подробная информация expandableInfo скрыта по умолчанию
    var actual: String  = "yes"         //Актуально ли событие, если дата события раньше текуще, то событие неактуально
) {}