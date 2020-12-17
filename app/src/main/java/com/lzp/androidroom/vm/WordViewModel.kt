package com.lzp.androidroom.vm

import androidx.lifecycle.*
import com.lzp.androidroom.Word
import com.lzp.androidroom.repository.WordRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

/**
 * @author li.zhipeng
 * */
class WordViewModel(private val repository: WordRepository): ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

}

class WordViewModelFactory(private val repository: WordRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)){
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }

}