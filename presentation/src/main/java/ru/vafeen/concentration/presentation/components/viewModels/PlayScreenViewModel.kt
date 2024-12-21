package ru.vafeen.concentration.presentation.components.viewModels

import androidx.lifecycle.ViewModel
import ru.vafeen.concentration.domain.Settings
import ru.vafeen.concentration.domain.service.SettingsManager

internal class PlayScreenViewModel(private val settingsManager: SettingsManager) : ViewModel() {
    // Поток с настройками приложения
    val settingsFlow = settingsManager.settingsFlow

    /**
     * Функция для сохранения настроек в SharedPreferences.
     * @param saving Функция, изменяющая настройки.
     */
    fun saveSettingsToSharedPreferences(saving: (Settings) -> Settings) {
        settingsManager.save(saving)
    }

}