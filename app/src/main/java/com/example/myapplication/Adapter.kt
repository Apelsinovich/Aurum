package com.example.myapplication

/***
 *Класс адаптер. Adapter необходим для управления View, заполнением View, определением объектов (кнопки, TextView и т.д.)
 ***/

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter internal constructor(
    //private var context: Context,
    private var data: ArrayList<Event>
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val buttonNameExpanded: String = "Подробнее"
    private val buttonNameNotExpanded: String = "Скрыть"

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    //тут создаем текст вью
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val event = data[position]
        holder.eventCaption.text = event.caption
        holder.eventInfo.text = event.info
        holder.eventDate.setImageResource(event.date)
        holder.eventExpandableInfo.text = event.expandableInfo

        //Ниже код связан с раскрытием CardView
        val isExpanded: Boolean = data[position].expanded
        //holder.eventExpandableLayer.setVisibility(if (isExpanded) else View.GONE)

           if (isExpanded) {
            holder.eventButton.text = buttonNameNotExpanded
            holder.eventExpandableLayer.visibility = View.VISIBLE
        }
            else {
            holder.eventButton.text = buttonNameExpanded
            holder.eventExpandableLayer.visibility = View.GONE
            }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return data.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        //super(itemView)
        var eventCaption: TextView
        var eventInfo: TextView
        var eventDate: ImageView
        var eventExpandableInfo: TextView
        var eventExpandableLayer: LinearLayout
        var eventButton: Button
        //var tvEventExpand_info: TextView = itemView.tvEventExpand_info
        init {
            eventCaption = itemView.findViewById(R.id.tvEvent_caption)
            eventInfo = itemView.findViewById(R.id.tvEvent_info)
            eventDate = itemView.findViewById(R.id.ivEvent_photo)
            eventExpandableInfo = itemView.findViewById(R.id.tvEventExpand_info)
            eventExpandableLayer = itemView.findViewById(R.id.expandEvent)
            eventButton = itemView.findViewById(R.id.expandBtn)

            eventButton.setOnClickListener {
                val event: Event = data[adapterPosition]
                event.expanded = !event.expanded
                notifyItemChanged(adapterPosition)
            }
        }
    }
}