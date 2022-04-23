package hu.bme.aut.android.lotrappandroid.main

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkProvider: NetworkProvider

    init{
        lifecycleScope.launch {
            delay(10000)
            println("xxx" + networkProvider.fetchCharacterList().toString())
        }
    }

}