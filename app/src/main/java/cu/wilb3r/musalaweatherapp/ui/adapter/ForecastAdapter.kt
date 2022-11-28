package cu.wilb3r.musalaweatherapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cu.wilb3r.musalaweatherapp.data.models.onecall.Daily
import cu.wilb3r.musalaweatherapp.databinding.ItemHForecastBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class ForecastAdapter @Inject constructor(@ApplicationContext private val context: Context) : RecyclerView.Adapter<ForecastViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Daily>() {
        override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem.dt == newItem.dt
        }

        override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem == newItem
        }
    }

    private var current: Double? = null
    fun setCurrent(value: Double) {
        current = value
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    private var items: List<Daily>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    fun submitList(items: List<Daily>) {
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            ItemHForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, current!!, position == 0)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}

//DateTime.now().add(Duration(seconds: timezone - DateTime.now().timeZoneOffset.inSeconds))

//const sunrise = new Date((data.sys.sunrise + data.timezone) * 1000)