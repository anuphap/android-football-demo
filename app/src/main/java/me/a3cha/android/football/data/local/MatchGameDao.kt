package me.a3cha.android.football.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import android.database.sqlite.SQLiteConstraintException
import me.a3cha.android.football.data.models.MatchGame

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Dao
abstract class MatchGameDao {
    @Insert
    abstract fun insertMatch(matchGame: MatchGame)

    @Update
    abstract fun updateMatch(matchGame: MatchGame)

    @Query("SELECT * FROM MatchGame")
    abstract fun getNewsList(): List<MatchGame>

    fun saveMaths(matches: List<MatchGame>?) {
        for (match in matches ?: arrayListOf()) {
            try {
                insertMatch(match)
            } catch (e: SQLiteConstraintException) {
                updateMatch(match)
            }
        }
    }
}