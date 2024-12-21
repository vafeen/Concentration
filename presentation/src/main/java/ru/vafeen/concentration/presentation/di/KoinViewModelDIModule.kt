package ru.vafeen.concentration.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vafeen.concentration.presentation.MainActivityViewModel
import ru.vafeen.concentration.presentation.components.viewModels.PlayScreenViewModel

internal val koinViewModelDIModule = module {
    viewModelOf(::MainActivityViewModel)
    viewModelOf(::PlayScreenViewModel)
}