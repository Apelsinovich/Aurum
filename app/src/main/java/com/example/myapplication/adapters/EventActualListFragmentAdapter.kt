package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Event
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_event.view.*

class EventActualListFragmentAdapter internal constructor(
    //private var context: Context,
    private var data: ArrayList<Event>
) :
    RecyclerView.Adapter<EventActualListFragmentAdapter.ViewHolder>() {
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
        holder.caption.text = event.title
        holder.info.text = event.info
        //holder.image.setImageDrawable(event.image)
        holder.detailedInfo.text = event.detailedInfo
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
        //super(itemView)
        var caption: TextView = itemView.tvEventCaption
        var info: TextView = itemView.tvEventInfo
       // var ivEventDate: ImageView = itemView.findViewById(R.id.ivEvent_photo)
        var image: ImageView = itemView.findViewById(R.id.ivEventImage)
        var detailedInfo: TextView = itemView.tvEventdetailedInfo
        //var tvEventExpand_info: TextView = itemView.tvEventExpand_info
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