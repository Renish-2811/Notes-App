package com.example.inotes

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: WordRepository

     val allWords : LiveData<List<Notes>>



    init {
                 val dao = WordRoomDatabase.getDatabase(application).wordDao()
                 repository = WordRepository(dao)
                 allWords = repository.allWords

             }
            fun deletenode(note:Notes) = viewModelScope.launch(Dispatchers.IO) {  repository.delete(note)}

    fun insert(note:Notes) = viewModelScope.launch(Dispatchers.IO) {  repository.insert(note)}

}

