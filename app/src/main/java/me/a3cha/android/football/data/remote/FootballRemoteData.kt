package me.a3cha.android.football.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import me.a3cha.android.football.app.Constants
import me.a3cha.android.football.data.models.MatchGame
import me.a3cha.android.football.data.models.Schedule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

class FootballRemoteData : FootballRemoteDataSource {
    private var footballService: FootballService

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader(HEADER_AUTHORIZATION, Constants.CLIENT_TOKEN)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor)
            .build()

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .create()


        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.HOST_NAME)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        footballService = retrofit.create(FootballService::class.java)
    }

    override fun loadMatches(): LiveData<List<MatchGame>> {
        val data = MutableLiveData<List<MatchGame>>()

        footballService.getSchedules("PL").enqueue(object : Callback<Schedule> {
            override fun onFailure(call: Call<Schedule>, t: Throwable) {

            }

            override fun onResponse(call: Call<Schedule>, response: Response<Schedule>) {
                data.value = response.body()?.matchGames
            }
        })

        return data
    }

    companion object {
        private const val HEADER_AUTHORIZATION = "X-Auth-Token"
    }
}