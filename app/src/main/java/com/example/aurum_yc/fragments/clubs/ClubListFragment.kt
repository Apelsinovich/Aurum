package com.example.aurum_yc.fragments.clubs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aurum_yc.R
import com.example.aurum_yc.adapters.ClubFragmentAdapter
import com.example.aurum_yc.models.clubs.Club
import com.example.aurum_yc.models.clubs.ClubFactory

class ClubListFragment : Fragment() {

    private var arrayOfClubs: ArrayList<Club> = ArrayList()
    private lateinit var clubFragmentAdapter: ClubFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // TODO обработать что секций нет, например инициализировать сразу пустым кард вью

        val v: View? = inflater.inflate(R.layout.fragment_club_list, container, false)
        val clubRecyclerView: RecyclerView = v!!.findViewById(R.id.club_recycler_view)

        // Очень важно - передавать this.context а не activity (отоборажаться не будет). И почему я передавал activity???????"
        // TODO - решить проблему с ошибкой 2020-10-14 07:55:00.487 5002-5002/com.example.myapplication E/RecyclerView: No adapter attached; skipping layout
        clubRecyclerView.layoutManager = LinearLayoutManager(this.context)

        val clubFactory = ClubFactory(context)
        arrayOfClubs = clubFactory.getClubs() as ArrayList<Club>

        clubFragmentAdapter = ClubFragmentAdapter(context, arrayOfClubs)
        clubRecyclerView.adapter = clubFragmentAdapter

        return v

    }
}