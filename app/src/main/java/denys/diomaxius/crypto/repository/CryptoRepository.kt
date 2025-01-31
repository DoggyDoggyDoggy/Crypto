package denys.diomaxius.crypto.repository

import denys.diomaxius.crypto.api.CryptoApi
import denys.diomaxius.crypto.data.model.CryptoCurrency
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val api: CryptoApi
) {
    suspend fun getCrypto(): List<CryptoCurrency> {
        return api.getCrypto()
    }
}
