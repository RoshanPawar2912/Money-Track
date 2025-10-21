package `in`.co.moneytrack.ui.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.co.moneytrack.data.model.Transaction
import `in`.co.moneytrack.data.repo.TransactionRepo
import javax.inject.Inject

@HiltViewModel
class FormExpenseVM @Inject constructor(
    val transactionRepo: TransactionRepo
) : ViewModel() {
    var transaction: Transaction? = null
}