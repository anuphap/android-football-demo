package me.a3cha.android.football.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.SerializedName
import me.a3cha.android.football.data.local.ScoreConverters
import me.a3cha.android.football.data.local.SeasonConverters
import me.a3cha.android.football.data.local.TeamConverters
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
//    @TypeConverters(SeasonConverters::class)
    var season: Season,
    var utcDate: Date,
    var status: String,
    var matchday: Int,
    var stage: String,
    var group: String,
    var lastUpdated: Date,
//    @TypeConverters(TeamConverters::class)
    var homeTeam: Team,
//    @TypeConverters(TeamConverters::class)
    var awayTeam: Team,
//    @TypeConverters(ScoreConverters::class)
    var score: Score
)