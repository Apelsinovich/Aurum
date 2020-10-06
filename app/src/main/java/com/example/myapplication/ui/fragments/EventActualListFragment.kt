package com.example.myapplication.ui.fragments

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

class EventActualListFragment : Fragment(){

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

        val eventFactory = EventFactory(context)
        val events: List<Event> = eventFactory.getEvents()
        // TODO обработать что новостей нет, например инициализировать сразу пустым кард вью
        // TODO вывести логику проверки на актуальность событий во внешний класс менеджер + проверить не создается ли лишний раз список событий
        events.forEach{
            if (it.isActual) {
                arrayOfEvents.add(it)
            }
        }
        eventActualListFragmentAdapter = EventActualListFragmentAdapter(context, arrayOfEvents)
        eventRecyclerView.adapter = eventActualListFragmentAdapter
        return v
    }

}