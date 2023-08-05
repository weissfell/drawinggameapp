package com.plcoding.doodlekong.util

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

//extension context
val Context.dataStore by preferencesDataStore("settings")