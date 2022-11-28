package cu.wilb3r.musalaweatherapp.ef

import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.view.View
import kotlin.math.roundToInt

fun Double.toCelsius() = this.minus(273.15).roundToInt().toString().plus(0x00B0.toChar())
fun Double.toCelsiusNoSign() = this.minus(273.15)

fun String.setFontSizeForPath(path: String): SpannableString {
    val spannable = SpannableString(this)
    val start = path.length.minus(2)
    spannable.setSpan(
        AbsoluteSizeSpan(39),
        start,
        path.length,
        0
    )

    return spannable
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.setVisible(visible: Boolean) {
    if (visible) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}