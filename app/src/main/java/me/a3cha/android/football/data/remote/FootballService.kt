package me.a3cha.android.football.data.remote

import me.a3cha.android.football.data.models.Schedule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

internal interface FootballService {

    @GET("/v2/competitions/{competition_code}/matches")
    fun getSchedules(
        @Path("competition_code") pl: String,
        @Query("matchday") matchday: String
    ): Call<Schedule>

    @GET("/v2/competitions/{competition_code}/matches")
    fun getSchedules(
        @Path("competition_code") pl: String
    ): Call<Schedule>
}