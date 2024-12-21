package ru.vafeen.concentration.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vafeen.concentration.presentation.navigation.NavigationRoot
import ru.vafeen.concentration.presentation.ui.theme.MainTheme

class MainActivity : ComponentActivity() {
    private val vModel: MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainTheme {
                NavigationRoot(viewModel = vModel)
            }
        }
    }
}
