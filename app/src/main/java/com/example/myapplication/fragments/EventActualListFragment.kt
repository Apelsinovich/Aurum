package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.EventActualListFragmentAdapter
import com.example.myapplication.models.Event
import com.example.myapplication.models.EventFactory

class EventActualListFragment : Fragment() {

    private var arrayOfEvents: ArrayList<Event> = ArrayList()
    private lateinit var eventActualListFragmentAdapter: EventActualListFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_actual_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        val eventFactory: EventFactory = EventFactory(context)
        val events: List<Event> = eventFactory.getEvents()

        arrayOfEvents = events as ArrayList<Event>

        //Заменить на класс,в котором создастся список

/*        arrayOfEvents.add(
            Event(
                1,
                "Флешмоб \"#БытьМамойЭто\"\n" +
                        "Что такое быть мамой и какие горизонты нам открывает материнство?",
                "8 июня - 20 июня",
                "Отличное событие и подарки хорошие"
            )
        )
        arrayOfEvents.add(
            Event(
                2,
                "Событие номер 2",
                "1 июля",
                "Приходите, будет весело"
            )
        )
        arrayOfEvents.add(
            Event(
                3,
                "Собыьтие номер 3",
                "21 июля",
                "День рождения, 30 лет как ни крути"
            )
        )
        arrayOfEvents.add(
            Event(
                4,
                "Событие номер 4",
                "16 августа",
                "qОсень, скоро осень"
            )
        )
        arrayOfEvents.add(
            Event(
                5,
                "qwertdfdfdsfy222",
                "qasdf",
                "qasdfa"
            )
        )*/
        eventActualListFragmentAdapter = EventActualListFragmentAdapter(arrayOfEvents)
        eventRecyclerView.adapter = eventActualListFragmentAdapter
        return v
    }
}