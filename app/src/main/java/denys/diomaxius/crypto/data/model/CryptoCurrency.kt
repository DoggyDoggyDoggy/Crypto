package denys.diomaxius.crypto.data.model

import com.google.gson.annotations.SerializedName

data class CryptoCurrency(
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("current_price") val price: Double
)

