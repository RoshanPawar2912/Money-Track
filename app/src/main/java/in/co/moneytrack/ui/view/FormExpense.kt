package `in`.co.moneytrack.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import `in`.co.moneytrack.R
import `in`.co.moneytrack.data.model.Transaction
import `in`.co.moneytrack.databinding.ActivityFormExpenseBinding
import `in`.co.moneytrack.databinding.ActivityHomeBinding
import `in`.co.moneytrack.ui.viewModel.FormExpenseVM
import `in`.co.moneytrack.utils.Utils
import kotlinx.coroutines.launch

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
        initializeListeners()

    }

    private fun initializeListeners() {
        binding.btnSave.setOnClickListener {
            save()
        }
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

    fun save() {
        Log.e("TAG", "save: ${binding.etAmount.text.toString()}", )
        if (binding.etAmount.text.toString().isEmpty()) {
            Utils.showToast(this, "Enter amount")
            return
        }

        if (binding.etNote.text.toString().isEmpty()) {
            Utils.showToast(this, "Enter note")
            return
        }

        getTransaction()?.let { safeTransaction ->
            lifecycleScope.launch {
                safeTransaction.localUUID.let {
                    vm.transactionRepo.save(safeTransaction)
                } ?: run {

                }
            }
        }
    }

    fun getTransaction(): Transaction? {
        if (vm.transaction == null) vm.transaction = Transaction()
        vm.transaction?.type = "Expense"
        vm.transaction?.amount = binding.etAmount.text.toString().toDoubleOrNull()
        vm.transaction?.date = System.currentTimeMillis()
        vm.transaction?.note = binding.etNote.text.toString()
        return vm.transaction
    }
}