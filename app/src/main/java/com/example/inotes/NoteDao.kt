package com.example.inotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(note: Notes)

 @Delete
 suspend fun delete(note: Notes)

 @Query("Select * from notest order by id ASC")
 fun gan(): LiveData<List<Notes>>

}