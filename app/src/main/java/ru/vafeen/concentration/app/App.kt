package ru.vafeen.concentration.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.vafeen.concentration.presentation.di.base.mainPresentationModule

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(mainPresentationModule)
        }
    }
}