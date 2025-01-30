package denys.diomaxius.crypto.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import denys.diomaxius.crypto.api.RetrofitInstance
import denys.diomaxius.crypto.data.model.CryptoCurrency
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val api = RetrofitInstance.api

    private val _cryptoList = MutableStateFlow<List<CryptoCurrency>>(emptyList())
    val cryptoList = _cryptoList.asStateFlow()

    init {
        fetchCrypto()
    }

    fun fetchCrypto() {
        viewModelScope.launch {
            try {
                _cryptoList.value = api.getCrypto()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}