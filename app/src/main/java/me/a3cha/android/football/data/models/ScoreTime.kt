package me.a3cha.android.football.data.models

import android.arch.persistence.room.Entity

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Entity
data class ScoreTime(
    var homeTeam: Int,
    var awayTeam: Int
)