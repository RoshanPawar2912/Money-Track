package `in`.co.moneytrack.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
import javax.annotation.Nonnull

@Entity(tableName = "my_transaction")
data class Transaction(
    @PrimaryKey
    var _localId: String = UUID.randomUUID().toString(),

    var localUUID: String? = null,
    var type: String? = null,
    var amount: Double? = null,
    var note: String? = null,
    var date: Long? = null
)