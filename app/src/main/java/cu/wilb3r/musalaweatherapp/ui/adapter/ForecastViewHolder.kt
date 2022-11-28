package cu.wilb3r.musalaweatherapp.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import coil.load
import cu.wilb3r.musalaweatherapp.R
import cu.wilb3r.musalaweatherapp.data.models.onecall.Daily
import cu.wilb3r.musalaweatherapp.databinding.ItemHForecastBinding
import cu.wilb3r.musalaweatherapp.ef.toCelsius
import cu.wilb3r.musalaweatherapp.ef.toCelsiusNoSign
import cu.wilb3r.musalaweatherapp.utils.Api
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.roundToInt

class ForecastViewHolder(private val binding: ItemHForecastBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("StringFormatInvalid", "NewApi")
    fun bind(item: Daily, current: Double?, isFirst: Boolean = false) {
        binding.apply {
            time.text = if (isFirst) "Today"
            else Instant.ofEpochSecond(item.dt.toLong())
                .atZone(ZoneId.of(TimeZone.getDefault().id))
                .format(
                    DateTimeFormatter.ofPattern(
                        ("EEE")
                    )
                )

            icon.load(Api.MEDIAURL + item.weather[0].icon + Api.IMG_2F)
            minTemp.text = item.temp.min.toCelsius()
            current?.let {
                if (isFirst) {
                    differ.progress =
                        ((it.toCelsiusNoSign() / item.temp.max.toCelsiusNoSign()) * 100).minus(10)
                            .toInt()
                } else differ.progress = 0
            }
            maxTemp.text = item.temp.max.toCelsius()
            pop.text = binding.root.context.getString(
                R.string.percent_formated,
                (item.pop * 100).roundToInt().toString()
            ).plus("%")
            txtDesc.text = item.weather[0].description
        }
    }
}