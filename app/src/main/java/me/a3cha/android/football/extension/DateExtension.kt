package me.a3cha.android.football.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Anuphap Suwannamas on 18/10/2018 AD.
 * Email: Anupharpae@gmail.com
 */

fun Date.formatter(): String {
    val dateFormatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
    return dateFormatter.format(this)
}
