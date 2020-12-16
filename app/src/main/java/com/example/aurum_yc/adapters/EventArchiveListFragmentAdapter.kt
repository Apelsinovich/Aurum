package com.example.aurum_yc.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aurum_yc.R
import com.example.aurum_yc.activities.EventActivity
import com.example.aurum_yc.db.events.data.Event
import kotlinx.android.synthetic.main.fragment_event.view.*
import java.text.SimpleDateFormat

class EventArchiveListFragmentAdapter () :
    RecyclerView.Adapter<EventArchiveListFragmentAdapter.ViewHolder>() {
    private val buttonNameExpanded: String = "Подробнее"
    private val buttonNameNotExpanded: String = "Скрыть"
//    прочитать про emptyList
    private var data = emptyList<Event>()

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_event, parent, false)
        return ViewHolder(view)
    }

    /* Логика связывания(bind) конкретных данных с полями */
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val event = data[position]
        holder.eventTitle.text = event.TITLE
//        TODO вынести логику преобразования даты в model, и избавить от дублирования перевода строки в long (на данный момент, перевод в лонг происходит и в EventActualListFragment)
        val date = event.DATE.toLong()
        val formatExample = SimpleDateFormat("dd.MM.yyyy")

        holder.eventDate.text = formatExample.format(date)
        holder.eventPlace.text = event.PLACE

/*Логика раскрывабщегося события. Отключена и заменена на локику открытия отдельного события (event) в новом активити*/

//        val isExpanded: Boolean = data[position].expanded
//
//        if (isExpanded) {
//            holder.eventButton.text = buttonNameNotExpanded
//            holder.eventExpandableLayer.visibility = View.VISIBLE
//        }
//        else {
//            holder.eventButton.text = buttonNameExpanded
//            holder.eventExpandableLayer.visibility = View.GONE
//        }
    }

    /* Логика подсчета количества строк в recyclerview */
    override fun getItemCount(): Int {
        return data.size
    }

    /*    Удерживание view в recyclerview + добавление новых по мере прокрутки вниз. stores and recycles views as they are scrolled off screen*/
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val eventTitle: TextView = itemView.tvEventTitle
        val eventDate: TextView = itemView.tvEventDate
        val eventPlace: TextView = itemView.tvEventPlace

        private val eventCardView: CardView = itemView.findViewById(R.id.cardEvent)

//        init {
//            eventButton.setOnClickListener {
//                val event: Event = data[adapterPosition]
//                event.expanded = !event.expanded
//                notifyItemChanged(adapterPosition)
//            }
//        }

        init {
/* Логика передачи в бандл интента (ассоциативный массив) данных выбранного события по нажатию на cardview*/

            eventCardView.setOnClickListener {
                val event = data[adapterPosition]

/* Логика раскрывабщегося события в recyclerview. Отключена за ненадобностью */

//                event.expanded = !event.expanded
//                notifyItemChanged(adapterPosition)

                //todo - подумать как передавать данные  при помощи функции. Наблюдается проблема дублирования кода. Цепочка адаптер - активити - фрагмент
                var intent = Intent(it.context, EventActivity::class.java)

                intent.putExtra("eventTitle", event.TITLE)
                intent.putExtra("eventDetailInfo", event.DETAILINFO)
                intent.putExtra("eventDate", event.DATE)
                intent.putExtra("eventPlace", event.PLACE)

                it.context!!.startActivity(intent)
            }
        }

    }
    fun setData(events: List<Event>) {
        this.data = events as ArrayList<Event>
        notifyDataSetChanged()
    }
}