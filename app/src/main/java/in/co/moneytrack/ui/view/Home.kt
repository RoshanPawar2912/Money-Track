package `in`.co.moneytrack.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import `in`.co.moneytrack.R
import `in`.co.moneytrack.databinding.ActivityHomeBinding
import `in`.co.moneytrack.ui.viewModel.HomeVM

@AndroidEntryPoint
class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val vm: HomeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureActivity()
    }

    fun configureActivity() {
        initializeUi()
        initializeListeners()
    }

    fun initializeUi() {
//        setTypeDropDown()
    }

    fun initializeListeners() {
        binding.bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottomNavigationHome -> {
                    return@setOnItemSelectedListener true
                }
                R.id.bottomNavigationExpense -> {
                    startActivity(Intent(this, FormExpense::class.java))
                    return@setOnItemSelectedListener true
                }
                R.id.bottomNavigationHome -> {
                    startActivity(Intent(this, FormExpense::class.java))
                    return@setOnItemSelectedListener true
                }

                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }
}