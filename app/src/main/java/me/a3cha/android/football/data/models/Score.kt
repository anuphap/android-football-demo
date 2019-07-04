package me.a3cha.android.football.data.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Entity
data class Score(
    var winner: String,
    var duration: String,
    @Embedded(prefix = "ft_")
    var fullTime: ScoreTime,
    @Embedded(prefix = "ht_")
    var halfTime: ScoreTime,
    @Embedded(prefix = "ex_")
    var extraTime: ScoreTime,
    @Embedded(prefix = "pen_")
    var penalties: ScoreTime
)