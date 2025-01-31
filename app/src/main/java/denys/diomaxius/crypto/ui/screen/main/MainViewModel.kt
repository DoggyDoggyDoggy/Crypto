package denys.diomaxius.crypto.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.crypto.data.model.CryptoCurrency
import denys.diomaxius.crypto.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    private val _cryptoList = MutableStateFlow<List<CryptoCurrency>>(emptyList())
    val cryptoList = _cryptoList.asStateFlow()

    init {
        fetchCrypto()
    }

    fun fetchCrypto() {
        viewModelScope.launch {
            try {
                _cryptoList.value = repository.getCrypto()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
