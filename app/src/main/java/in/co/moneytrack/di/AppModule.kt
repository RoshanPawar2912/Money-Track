package `in`.co.moneytrack.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import `in`.co.moneytrack.data.dao.TransactionDao
import `in`.co.moneytrack.data.repo.TransactionRepo
import `in`.co.moneytrack.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTransactionDao(appDatabase: AppDatabase): TransactionDao {
        return appDatabase.provideTransactionDao()
    }

    @Provides
    @Singleton
    fun provideTransactionRepo(transactionDao: TransactionDao): TransactionRepo {
        return TransactionRepo(transactionDao)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "money_track_db"
        ).build()
    }
}