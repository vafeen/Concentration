package ru.vafeen.concentration.data.di.base

import org.koin.dsl.module
import ru.vafeen.concentration.data.di.servicesModule

val mainDataModule = module {
    includes(servicesModule)
}