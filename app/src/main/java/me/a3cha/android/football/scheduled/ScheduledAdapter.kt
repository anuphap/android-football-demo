package me.a3cha.android.football.scheduled

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_scheduled.view.*
import me.a3cha.android.football.R
import me.a3cha.android.football.data.models.MatchGame
import me.a3cha.android.football.extension.formatter

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

class ScheduledAdapter : RecyclerView.Adapter<ScheduledAdapter.ScheduledViewHolder>() {
    var matches = arrayListOf<MatchGame>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduledViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_scheduled, parent, false)
        return ScheduledViewHolder(view)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: ScheduledViewHolder, position: Int) {
        holder.bindItem(matches[position])
    }

    inner class ScheduledViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(matchGame: MatchGame) {
            itemView.tvDateTime.text = matchGame.utcDate.formatter()
            itemView.tvHomeTeam.text = matchGame.homeTeam.name
            itemView.tvAwayTeam.text = matchGame.awayTeam.name
        }
    }
}