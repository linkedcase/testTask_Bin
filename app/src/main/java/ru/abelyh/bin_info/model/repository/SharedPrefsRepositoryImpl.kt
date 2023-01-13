package ru.abelyh.bin_info.model.repository

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.abelyh.bin_info.view_model.UserViewModel

class SharedPrefsRepositoryImpl : SharedPrefsRepository {
//    private val userViewModel: UserViewModel = UserViewModel()
//    private val type = TypeToken.getParameterized(List::class.java, String::class.java).type
//    private var listBinNumbers = userViewModel.binNumbers
//    private val data: MutableLiveData<List<String>>
//    private var prefs =
//        application.getSharedPreferences("settings", Context.MODE_PRIVATE)
//    private var bin
//        get() = checkNotNull(data.value) {
//            "Data value should not be null"
//        }
//        set(value) {
//            prefs.edit {
//                val serializedBin = Json.encodeToString(value)
//                putString(APP_PREFERENCES_BIN, serializedBin)
//            }
//            data.value = value
//        }

//    val editor = prefs.edit()
//    editor.putString(APP_PREFERENCES_BIN, listBinNumbers).apply()
//    listBinNumbers = prefs.getString(APP_PREFERENCES_BIN, null).toString()
//    viewModel.binNumbers.add(listBinNumbers)

//    init {
//        val serializedBin = prefs.getString(APP_PREFERENCES_BIN, null)
//        val bin: List<String> = if (serializedBin != null) {
//            Json.decodeFromString(serializedBin)
//        } else emptyList()
//        data = MutableLiveData(bin)
//    }

//    fun getAll(): MutableLiveData<ArrayList<String>> = data

    override fun saveInPrefs(key: String) {
    }

    override fun getFromPrefs(key: String) {
    }

//    private companion object {
//        private const val APP_PREFERENCES_BIN = "bin"
//    }
}