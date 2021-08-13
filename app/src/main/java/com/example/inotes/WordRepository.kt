package com.example.inotes

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class WordRepository(private val wordDao: NoteDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWords: LiveData<List<Notes>> = wordDao.gan();

    suspend fun insert(note: Notes) {
        wordDao.insert(note)
    }
    suspend fun delete(note: Notes) {
        wordDao.delete(note)
    }

}