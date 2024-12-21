package ru.vafeen.concentration.presentation.di.base


import org.koin.dsl.module
import ru.vafeen.concentration.presentation.di.koinViewModelDIModule


val mainPresentationModule = module {
    includes(koinViewModelDIModule)
}