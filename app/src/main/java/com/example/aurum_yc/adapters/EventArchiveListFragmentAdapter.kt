package com.example.aurum_yc.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aurum_yc.db.events.data.Event
import com.example.aurum_yc.R
import kotlinx.android.synthetic.main.fragment_event.view.*
import kotlin.collections.ArrayList

class EventArchiveListFragmentAdapter internal constructor(
    private var context: Context?,
    private var data: ArrayList<Event>
) :
    RecyclerView.Adapter<EventArchiveListFragmentAdapter.ViewHolder>() {
    private val buttonNameExpanded: String = "Подробнее"
    private val buttonNameNotExpanded: String = "Скрыть"

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_event, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    //тут создаем текст вью
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val event = data[position]
        holder.eventTitle.text = event.TITLE
        holder.eventDate.text = event.DATE
        holder.eventPlace.text = event.PLACE

        ////////////////////////
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

        var eventTitle: TextView = itemView.tvEventTitle
        var eventDate: TextView = itemView.tvEventDate
        var eventPlace: TextView = itemView.tvEventPlace

        var image: ImageView = itemView.findViewById(R.id.ivEventImage)

        var eventButton: Button = itemView.findViewById(R.id.expandBtn)
        var eventExpandableLayer: LinearLayout = itemView.findViewById(R.id.expandEvent)

        init {
            eventButton.setOnClickListener {
                val event: Event = data[adapterPosition]
                event.expanded = !event.expanded
                notifyItemChanged(adapterPosition)
            }
        }
    }

}