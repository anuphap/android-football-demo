package me.a3cha.android.football.data.models

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName


/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Entity
data class Season(
    @SerializedName("id")
    var seasonId: Long,
    var startDate: String,
    var endDate: String,
    var currentMatchDay: Int
)
