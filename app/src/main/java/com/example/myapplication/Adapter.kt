package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_row.view.*


class Adapter internal constructor(
    private var context: Context,
    private var data: ArrayList<Event>
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

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
        holder.tvEventCaption.text = event.caption
        holder.tvEventInfo.text = event.info
        holder.ivEventDate.setImageResource(event.date)
        ////////////////////////
    }

    // total number of rows
    override fun getItemCount(): Int {
        return data.size
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        //super(itemView)
        var tvEventCaption: TextView = itemView.tvEvent_caption
        var tvEventInfo: TextView = itemView.tvEvent_info
        var ivEventDate: ImageView = itemView.findViewById(R.id.ivEvent_photo)
        //var tvEventExpand_info: TextView = itemView.tvEventExpand_info
    }

}