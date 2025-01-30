package denys.diomaxius.crypto.api

import denys.diomaxius.crypto.data.model.CryptoCurrency
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {
    @GET("coins/markets")
    suspend fun getCrypto(
        @Query("vs_currency") vsCurrency: String = "usd"
    ) : List<CryptoCurrency>
}