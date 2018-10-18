package me.a3cha.android.football.data

import android.arch.lifecycle.LiveData
import me.a3cha.android.football.data.local.LocalDatabase
import me.a3cha.android.football.data.models.MatchGame
import me.a3cha.android.football.data.remote.FootballRemoteData
import me.a3cha.android.football.data.remote.FootballRemoteDataSource


/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

class FootballRepository(private val remoteData: FootballRemoteData, private val localDatabase: LocalDatabase) :
    FootballRemoteDataSource {

    companion object {
        private var instance: FootballRepository? = null
        fun getInstance(remoteData: FootballRemoteData, localDatabase: LocalDatabase): FootballRepository {
            if (instance == null)
                instance = FootballRepository(remoteData, localDatabase)
            return instance as FootballRepository
        }
    }

    override fun loadMatches(): LiveData<List<MatchGame>> {
        val data = remoteData.loadMatches()
        localDatabase.matchGameDao().saveMaths(data.value) // save
        return data
    }
}
