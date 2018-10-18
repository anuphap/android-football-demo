package me.a3cha.android.football.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.a3cha.android.football.R
import me.a3cha.android.football.data.models.MatchGame

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

class ScheduledFragment : Fragment() {
    private lateinit var scheduledViewModel: ScheduledViewModel

    // widget view
    private lateinit var rvScheduled: RecyclerView
    private lateinit var adapter: ScheduledAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_scheduled, container, false)
        bindWidgetView(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        scheduledViewModel = ViewModelProviders.of(this).get(ScheduledViewModel::class.java)
        scheduledViewModel.loadMatches().observe(this, Observer<List<MatchGame>> { matches ->
            matches?.let { adapter.matches = it }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ScheduledAdapter()
        rvScheduled.layoutManager = LinearLayoutManager(context)
        rvScheduled.adapter = adapter
    }


    private fun bindWidgetView(view: View) {
        rvScheduled = view.findViewById(R.id.rvScheduled)
    }

}