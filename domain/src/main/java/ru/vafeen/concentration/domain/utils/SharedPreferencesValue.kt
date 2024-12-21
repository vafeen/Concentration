package ru.vafeen.concentration.domain.utils

enum class SharedPreferencesValue(val key: String) {
    Name(key = "SharedPreferences"),
    Settings(key = "Settings");
}