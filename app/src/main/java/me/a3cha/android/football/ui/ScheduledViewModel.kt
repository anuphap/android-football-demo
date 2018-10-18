package me.a3cha.android.football.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import me.a3cha.android.football.data.FootballRepository
import me.a3cha.android.football.data.local.LocalDatabase
import me.a3cha.android.football.data.models.MatchGame
import me.a3cha.android.football.data.remote.FootballRemoteData

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

open class ScheduledViewModel(application: Application) : AndroidViewModel(application) {
    private val repo by lazy {
        FootballRepository.getInstance(
            remoteData = FootballRemoteData(),
            localDatabase = LocalDatabase.getInstances(application)
        )
    }

    fun loadMatches(): LiveData<List<MatchGame>> {
        return repo.loadMatches()
    }
}