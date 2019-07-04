package me.a3cha.android.football.data.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Entity
data class MatchGame(
    @PrimaryKey
    @SerializedName("id")
    var matchId: Long,
    @Embedded
    var season: Season,
    var utcDate: Date,
    var status: String,
    var matchday: Int,
    var stage: String,
    var group: String,
    var lastUpdated: Date,
    @Embedded(prefix = "home_")
    var homeTeam: Team,
    @Embedded(prefix = "away_")
    var awayTeam: Team,
    @Embedded
    var score: Score
)