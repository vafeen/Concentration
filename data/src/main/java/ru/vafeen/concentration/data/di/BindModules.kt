package ru.vafeen.concentration.data.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.vafeen.concentration.data.service.impl.SettingsManagerImpl
import ru.vafeen.concentration.domain.service.SettingsManager
import ru.vafeen.concentration.domain.utils.SharedPreferencesValue


internal val servicesModule = module {
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            SharedPreferencesValue.Name.key, Context.MODE_PRIVATE
        )
    }
    singleOf(::SettingsManagerImpl) {
        bind<SettingsManager>()
    }
}

