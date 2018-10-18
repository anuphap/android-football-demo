package me.a3cha.android.football.data.models

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Created by Anuphap Suwannamas on 17/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

@Entity
data class Competition(
    @SerializedName("id")
    var competitionId: Long,
    var name: String,
    var code: String,
    var plan: String,
    var lastupdate: String
)