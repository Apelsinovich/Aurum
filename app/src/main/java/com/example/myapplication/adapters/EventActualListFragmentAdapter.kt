package com.example.myapplication.adapters

import android.content.ClipData.newIntent
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.activities.EventActivity
import com.example.myapplication.activities.MainMenuActivity
import com.example.myapplication.activities.SplashScreen
import com.example.myapplication.models.Event
import com.example.myapplication.ui.fragments.EventActualListFragment
import com.example.myapplication.ui.fragments.EventFragment
import kotlinx.android.synthetic.main.fragment_event.view.*

class EventActualListFragmentAdapter internal constructor(
    private var context: Context?,
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
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_event,
            parent,
            false
        )
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
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //super(itemView)
        var eventTitle: TextView = itemView.tvEventTitle
        var eventDate: TextView = itemView.tvEventDate
        var eventPlace: TextView = itemView.tvEventPlace

        var image: ImageView = itemView.findViewById(R.id.ivEventImage)

        var eventButton: Button = itemView.findViewById(R.id.expandBtn)
        var eventExpandableLayer: LinearLayout = itemView.findViewById(R.id.expandEvent)

        var eventCardView: CardView = itemView.findViewById(R.id.cardEvent)

        //var ivEventDate: ImageView = itemView.findViewById(R.id.ivEvent_photo)
        //var detailedInfo: TextView = itemView.tvEventdetailedInfo
        //var tvEventExpand_info: TextView = itemVieww  .tvEventExpand_info


        init {

            eventCardView.setOnClickListener {
                val event = data[adapterPosition]
//                event.expanded = !event.expanded
//                notifyItemChanged(adapterPosition)

//                // передаем в бандл интента (ассоциативный массив) айди события
                var intent = Intent(context, EventActivity::class.java)
               // intent.putExtra("eventUUID", event.UUID)
                intent.putExtra("eventTitle", event.TITLE)
                intent.putExtra("eventDetailInfo", event.DETAILINFO)
                intent.putExtra("eventDate", event.DATE)
                intent.putExtra("eventPlace", event.PLACE)


                context!!.startActivity(intent)
            }
        }
    }
}