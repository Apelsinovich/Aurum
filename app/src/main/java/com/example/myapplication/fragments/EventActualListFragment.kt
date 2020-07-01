package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.EventArchiveListFragmentAdapter
import com.example.myapplication.models.Event

class EventActualListFragment : Fragment() {

    private var arrayOfEvents: ArrayList<Event> = ArrayList()
    private lateinit var eventActualListFragmentAdapter: EventArchiveListFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View? = inflater.inflate(R.layout.fragment_event_actual_list, container, false)
        val eventRecyclerView: RecyclerView = v!!.findViewById(R.id.event_recycler_view)
        eventRecyclerView.layoutManager = LinearLayoutManager(activity)

        //Заменить на класс,в котором создастся список

        arrayOfEvents.add(
            Event(
                "Флешмоб \"#БытьМамойЭто\"\n" +
                        "Что такое быть мамой и какие горизонты нам открывает материнство?",
                "8 июня - 20 июня",
                "Отличное событие и подарки хорошие"
            )
        )
        arrayOfEvents.add(
            Event(
                "Событие номер 2",
                "1 июля",
                "Приходите, будет весело"
            )
        )
        arrayOfEvents.add(
            Event(
                "Собыьтие номер 3",
                "21 июля",
                "День рождения, 30 лет как ни крути"
            )
        )
        arrayOfEvents.add(
            Event(
                "Событие номер 4",
                "16 августа",
                "qОсень, скоро осень"
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
}