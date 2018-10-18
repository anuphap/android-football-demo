package me.a3cha.android.football.data.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.a3cha.android.football.data.models.Team

class TeamConverters {
    @TypeConverter
    fun fromSeason(team: Team?): String? {
        if (team == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Team>() {

        }.type
        return gson.toJson(team, type)
    }

    @TypeConverter
    fun toSeason(team: String?): Team? {
        if (team == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Team>() {

        }.type
        return gson.fromJson(team, type)
    }
}