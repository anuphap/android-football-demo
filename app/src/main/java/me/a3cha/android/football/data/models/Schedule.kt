package me.a3cha.android.football.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

data class Schedule(
    var count: Int,
    var competition: Competition,
    @SerializedName("matches")
    var matchGames: List<MatchGame>
)