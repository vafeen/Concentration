package ru.vafeen.concentration.domain

import com.google.gson.Gson

data class Settings(
    val cardsTheme: IconsTheme = IconsTheme.EMOJI_THEME,
) {
    /**
     * Преобразует объект [Settings] в строку формата JSON.
     *
     * @return Строка в формате JSON, представляющая объект [Settings].
     */
    fun toJsonString(): String = Gson().toJson(this)
}
