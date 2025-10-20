package `in`.co.moneytrack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "my_transaction")
data class Transaction(
    @PrimaryKey
    val uuid: String,
    val type: String,
    val amount: Double,
    val note: String,
    val date: Long
)