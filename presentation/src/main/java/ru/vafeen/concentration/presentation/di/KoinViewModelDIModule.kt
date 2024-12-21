package ru.vafeen.concentration.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vafeen.concentration.presentation.MainActivityViewModel
import ru.vafeen.concentration.presentation.components.viewModels.MainScreenViewModel
import ru.vafeen.concentration.presentation.components.viewModels.PlayScreenViewModel
import ru.vafeen.concentration.presentation.navigation.BottomBarNavigator

internal val koinViewModelDIModule = module {
    viewModelOf(::MainActivityViewModel)
    viewModelOf(::PlayScreenViewModel)
    viewModel { (navigator: BottomBarNavigator) -> MainScreenViewModel(navigator) }
}