package ru.abelyh.bin_info.model.repository

interface SharedPrefsRepository {
    /**
     * Saving data in the shared preferences
     */
    fun saveInPrefs(key: String)

    /**
     * Getting data out of the shared preferences
     */
    fun getFromPrefs(key: String)
}