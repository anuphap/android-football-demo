package me.a3cha.android.football.data.remote

import android.arch.lifecycle.LiveData
import me.a3cha.android.football.data.models.MatchGame


/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */
interface FootballRemoteDataSource {
    fun loadMatches(): LiveData<List<MatchGame>>
}