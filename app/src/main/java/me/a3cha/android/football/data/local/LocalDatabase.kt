package me.a3cha.android.football.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import me.a3cha.android.football.data.models.MatchGame

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Database(entities = [MatchGame::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class LocalDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "football_db"
        private var instances: LocalDatabase? = null

        fun getInstances(context: Context): LocalDatabase {
            if (instances == null) {
                instances = Room.databaseBuilder(context, LocalDatabase::class.java, DB_NAME).build()
            }
            return instances as LocalDatabase
        }
    }

    // region data model
    abstract fun matchGameDao(): MatchGameDao
    // endregion
}