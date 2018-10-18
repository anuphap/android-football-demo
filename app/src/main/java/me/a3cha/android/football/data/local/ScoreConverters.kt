package me.a3cha.android.football.data.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.a3cha.android.football.data.models.Score
import me.a3cha.android.football.data.models.Team

class ScoreConverters {
    @TypeConverter
    fun fromSeason(score: Score?): String? {
        if (score == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Score>() {}.type
        return gson.toJson(score, type)
    }

    @TypeConverter
    fun toSeason(score: String?): Score? {
        if (score == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Team>() {}.type
        return gson.fromJson(score, type)
    }
}