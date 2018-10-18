package me.a3cha.android.football.data.local

import android.arch.persistence.room.TypeConverter
import java.util.*


class DateConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = if (value == null) null else Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time
}
