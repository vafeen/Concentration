package ru.vafeen.concentration.presentation.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vafeen.concentration.presentation.MainActivityViewModel

internal val koinViewModelDIModule = module {
    viewModelOf(::MainActivityViewModel)
}