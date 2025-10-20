package `in`.co.moneytrack.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import `in`.co.moneytrack.data.model.Transaction

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transaction: Transaction): Transaction {
        return getByUUID(transaction.uuid)
    }

    @Query("SELECT * FROM my_transaction")
    suspend fun getTransactions(): List<Transaction>


//    @Delete
//    suspend fun deleteTransaction()

    @Query("SELECT * FROM my_transaction WHERE UUID = :uuid LIMIT 1")
    suspend fun getByUUID(uuid: String): Transaction
}