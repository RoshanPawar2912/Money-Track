package `in`.co.moneytrack.database

import androidx.room.Database
import androidx.room.RoomDatabase
import `in`.co.moneytrack.data.dao.TransactionDao
import `in`.co.moneytrack.data.model.Transaction

@Database(entities = [Transaction::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun provideTransactionDao(): TransactionDao
}