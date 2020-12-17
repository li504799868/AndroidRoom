package com.lzp.androidroom

import android.app.Application
import com.lzp.androidroom.database.WordRoomDatabase
import com.lzp.androidroom.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * @author li.zhipeng
 * */
class WordsApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {
        WordRoomDatabase.getDatabase(this, applicationScope)
    }

    val repository by lazy {
        WordRepository(database.wordDao())
    }

}