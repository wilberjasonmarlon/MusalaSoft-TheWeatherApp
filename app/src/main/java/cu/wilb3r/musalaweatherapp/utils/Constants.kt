package cu.wilb3r.musalaweatherapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.getDefault

object Api {
    const val BASEURL = "https://api.openweathermap.org/"
    const val PATH_DATA = "data/2.5/"
    const val PATH_GEO = "geo/1.0/"
    const val MEDIAURL = "https://openweathermap.org/img/wn/"
    const val WEATHER = "${PATH_DATA}weather"
    const val FORECAST = "${PATH_DATA}forecast"
    const val ONECALL = "${PATH_DATA}onecall"
    const val REVERSE = "${PATH_GEO}reverse"
    const val DIRECT = "${PATH_GEO}direct"
    const val API_KEY = "appid"
    const val QUERY = "q"
    const val ID = "id"
    const val LAT = "lat"
    const val LON = "lon"
    const val IMG_2F = "@2x.png"
    const val IMG_4F = "@4x.png"
}

object Generic {
    @SuppressLint("ConstantLocale")
    val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", getDefault())
    val now: Date = Calendar.getInstance().time
    val goo: String = "8.8.8.8"
}