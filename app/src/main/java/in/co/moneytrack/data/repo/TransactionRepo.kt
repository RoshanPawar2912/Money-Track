package `in`.co.moneytrack.data.repo

import `in`.co.moneytrack.data.dao.TransactionDao
import `in`.co.moneytrack.data.model.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

class TransactionRepo @Inject constructor(
    private val transactionDao: TransactionDao
) {
    suspend fun save(transaction: Transaction): Transaction = withContext(Dispatchers.IO) {
        transaction.localUUID = UUID.randomUUID().toString()
        transactionDao.insertTransaction(transaction)
    }

    suspend fun getTransactions() {

    }

    suspend fun deleteTransaction() {

    }
}