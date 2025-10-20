package `in`.co.moneytrack.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import `in`.co.moneytrack.R
import `in`.co.moneytrack.databinding.ActivityFormIncomeBinding

class FormIncome : AppCompatActivity() {
    lateinit var binding: ActivityFormIncomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}