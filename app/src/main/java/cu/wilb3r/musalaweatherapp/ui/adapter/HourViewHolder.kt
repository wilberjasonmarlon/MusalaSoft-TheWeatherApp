package cu.wilb3r.musalaweatherapp.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import coil.load
import cu.wilb3r.musalaweatherapp.data.models.onecall.Hourly
import cu.wilb3r.musalaweatherapp.databinding.ItemVForecastBinding
import cu.wilb3r.musalaweatherapp.ef.toCelsius
import cu.wilb3r.musalaweatherapp.utils.Api
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class HourViewHolder(private val binding: ItemVForecastBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("StringFormatInvalid", "NewApi")
    fun bind(item: Hourly, isFirst: Boolean = false) {
        binding.apply {
            time.text = if (isFirst) "\nNow"
            else Instant.ofEpochSecond(item.dt.toLong())
                .atZone(ZoneId.of(TimeZone.getDefault().id))
                .format(
                    DateTimeFormatter.ofPattern(
                        ("EEE\nha")
                    )
                )

            icon.load(Api.MEDIAURL + item.weather[0].icon + Api.IMG_2F)
            htemp.text = item.temp.toCelsius()
        }
    }
}