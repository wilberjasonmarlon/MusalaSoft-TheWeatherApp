package cu.wilb3r.musalaweatherapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import cu.wilb3r.musalaweatherapp.data.models.onecall.Hourly
import cu.wilb3r.musalaweatherapp.databinding.ItemVForecastBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class HourAdapter @Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<HourViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Hourly>() {
        override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
            return oldItem.dt == newItem.dt
        }

        override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
            return oldItem == newItem
        }
    }

    private var current: Double? = null
    fun setCurrent(value: Double) {
        current = value
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    private var items: List<Hourly>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    fun submitList(items: List<Hourly>) {
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder {
        return HourViewHolder(
            ItemVForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, position == 0)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}

//DateTime.now().add(Duration(seconds: timezone - DateTime.now().timeZoneOffset.inSeconds))

//const sunrise = new Date((data.sys.sunrise + data.timezone) * 1000)