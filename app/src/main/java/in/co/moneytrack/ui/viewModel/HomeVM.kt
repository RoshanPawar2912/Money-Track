package `in`.co.moneytrack.ui.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.co.moneytrack.data.model.Transaction
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
): ViewModel() {
    val transaction: Transaction? = null
}