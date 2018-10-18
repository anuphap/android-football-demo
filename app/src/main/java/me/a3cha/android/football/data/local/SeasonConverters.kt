package me.a3cha.android.football.data.local

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.a3cha.android.football.data.models.Season

class SeasonConverters {
    @TypeConverter
    fun fromSeason(season: Season?): String? {
        if (season == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Season>() {

        }.type
        return gson.toJson(season, type)
    }

    @TypeConverter
    fun toSeason(season: String?): Season? {
        if (season == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Season>() {

        }.type
        return gson.fromJson(season, type)
    }
}