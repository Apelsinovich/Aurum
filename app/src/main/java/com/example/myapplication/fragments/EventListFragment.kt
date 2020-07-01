package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.EventArchiveListFragmentAdapter
import com.example.myapplication.models.Event
import com.example.myapplication.R


class EventListFragment : Fragment() {
    private var arrayOfEvents: ArrayList<Event> = ArrayList()
    private var eventActualListFragmentAdapter: EventArchiveListFragmentAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        //Заменить на класс,в котором создастся список

        arrayOfEvents.add(
            Event(
                "Флешмоб \"#БытьМамойЭто\"\n" +
                        "Что такое быть мамой и какие горизонты нам открывает материнство?",
                "8 июня - 20 июня",
                "qwerty"
            )
        )
        arrayOfEvents.add(
            Event(
                "qwerty222",
                "qwet222t",
                "qwerty22"
            )
        )
        arrayOfEvents.add(
            Event(
                "sdfsfsdfasf",
                "qafsfddsft",
                "asdfasdf"
            )
        )
        arrayOfEvents.add(
            Event(
                "qwertaaaaay222",
                "qwaaaat",
                "qasdf"
            )
        )
        arrayOfEvents.add(
            Event(
                "qwertdfdfdsfy222",
                "qasdf",
                "qasdfa"
            )
        )
        eventActualListFragmentAdapter = EventArchiveListFragmentAdapter(arrayOfEvents)
        eventRecyclerView.adapter = eventActualListFragmentAdapter
        return v
    }

    /*private class EventHolder(inflater: LayoutInflater, parent: ViewGroup?) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_event, parent, false))


    private class EventAdapter internal constructor(
        //private var context: Context,
        private var events: ArrayList<Event>
    ) :
        RecyclerView.Adapter<EventHolder>() {*/


/*        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
            val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
            return EventHolder(
                layoutInflater,
                parent
            )
        }*/

/*        override fun getItemCount(): Int {
            //
            return events.size
        }

        override fun onBindViewHolder(holder: EventHolder, position: Int) {
            //
        }


    }*/
}

