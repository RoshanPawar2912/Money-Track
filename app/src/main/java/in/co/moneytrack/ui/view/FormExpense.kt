package `in`.co.moneytrack.ui.view

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import `in`.co.moneytrack.R
import `in`.co.moneytrack.databinding.ActivityFormExpenseBinding
import `in`.co.moneytrack.databinding.ActivityHomeBinding
import `in`.co.moneytrack.ui.viewModel.FormExpenseVM

@AndroidEntryPoint
class FormExpense : AppCompatActivity() {
    lateinit var binding: ActivityFormExpenseBinding
    private val vm: FormExpenseVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureActivity()
    }

    fun configureActivity() {
        initializeUi()
    }

    fun initializeUi() {
        setTypeDropDown()
    }

    fun setTypeDropDown() {
        binding.arrayAdapterType = ArrayAdapter(
            this,
            R.layout.spinner,
            listOf("Expense", "Income")
        )
    }
}