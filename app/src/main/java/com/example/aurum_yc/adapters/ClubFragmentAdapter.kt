package com.example.aurum_yc.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aurum_yc.R
import com.example.aurum_yc.models.clubs.Club
import kotlinx.android.synthetic.main.fragment_club.view.*


class ClubFragmentAdapter internal constructor(
    private var context: Context?,
    private var data: ArrayList<Club>
) :
    RecyclerView.Adapter<ClubFragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_club, parent, false)
        return ViewHolder(view)
    }

/* Логика связывания(bind) конкретных данных с полями */
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val club = data[position]
        holder.clubTitle.text = club.TITLE
        //holder.clubInfo.text = club.INFO
        //holder.clubDetailInfo.text = club.DETAILINFO
    }

/* Логика подсчета количества строк в recyclerview */
    override fun getItemCount(): Int {
        return data.size
    }

/*    Удерживание view в recyclerview + добавление новых по мере прокрутки вниз. stores and recycles views as they are scrolled off screen*/
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val clubTitle: TextView = itemView.tvClubTitle
        //val clubInfo: TextView = itemView.tvClubInfo
        //val clubDetailInfo: TextView = itemView.tvClubDetailInfo
//        val image: ImageView = itemView.findViewById(R.id.ivEventImage)
//        val eventButton: Button = itemView.findViewById(R.id.expandBtn)
//        val eventExpandableLayer: LinearLayout = itemView.findViewById(R.id.expandEvent)

        private val clubCardView: CardView = itemView.findViewById(R.id.cardClub)

//        init {
///* Логика передачи в бандл интента (ассоциативный массив) данных выбранного события по нажатию на cardview*/
//
//            clubCardView.setOnClickListener {
//                val event = data[adapterPosition]
//
///* Логика раскрывабщегося события в recyclerview. Отключена за ненадобностью */
//
////                event.expanded = !event.expanded
////                notifyItemChanged(adapterPosition)
//
//                //todo - подумать как передавать данные  при помощи функции. Наблюдается проблема дублирования кода. Цепочка адаптер - активити - фрагмент
//                var intent = Intent(context, ClubActivity::class.java)
//
//                intent.putExtra("clubTitle", event.TITLE)
//                intent.putExtra("clubInfo", event.INFO)
//                intent.putExtra("clubDetailInfo", event.DETAILINFO)
//
//                context!!.startActivity(intent)
//            }
//        }
    }
}