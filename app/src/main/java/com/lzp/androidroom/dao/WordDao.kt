package com.lzp.androidroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lzp.androidroom.Word
import kotlinx.coroutines.flow.Flow

/**
 * @author li.zhipeng
 * */
@Dao
interface WordDao {

    /**
     * 为了观察数据的变化，可以使用kotlin中协程的Flow
     * * */
    @Query("select * from word_table order by word asc")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("delete from word_table")
    suspend fun deleteAll()
}