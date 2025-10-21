package `in`.co.moneytrack.utils

import android.content.Context
import android.icu.util.Calendar
import android.widget.Toast

class Utils {
    companion object {
        fun showToast(context: Context, text: String, isLong: Boolean = false) {
            Toast.makeText(
                context,
                text,
                if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
            ).show()
        }

        fun getStartOfDayTimeStamp(timeSTamp: Long = System.currentTimeMillis()) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeSTamp
        }
    }
}