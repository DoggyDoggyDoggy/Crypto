package denys.diomaxius.crypto.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import denys.diomaxius.crypto.data.model.CryptoCurrency


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val cryptoList by viewModel.cryptoList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(cryptoList) { crypto ->
            CryptoItem(crypto)
        }
    }
}

@Composable
fun CryptoItem(crypto: CryptoCurrency) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column {
                Text(text = crypto.name, style = MaterialTheme.typography.titleLarge)
                Text(text = "$${crypto.price}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}










