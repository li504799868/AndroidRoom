package com.lzp.androidroom.repository

import androidx.annotation.WorkerThread
import com.lzp.androidroom.Word
import com.lzp.androidroom.dao.WordDao
import kotlinx.coroutines.flow.Flow

/**
 * @author li.zhipeng
 * */
class WordRepository(private val wordDao: WordDao) {

    val allWords : Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}