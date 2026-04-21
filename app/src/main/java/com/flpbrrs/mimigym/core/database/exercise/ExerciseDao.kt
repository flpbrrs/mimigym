package com.flpbrrs.mimigym.core.database.exercise

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query(
        """                                                                                                                                                                   
      SELECT * FROM exercises
      WHERE (:name IS NULL OR name LIKE '%' || :name || '%')
      AND (:muscleGroup IS NULL OR muscle_group IN (:muscleGroup))
  """
    )
    fun getFilteredList(name: String?, muscleGroup: String?): Flow<List<ExerciseEntity>>

    @Query("select distinct muscle_group from exercises")
    fun getUsedMuscleGroups(): Flow<List<String>>

    @Query("select * from exercises where id = :id")
    suspend fun getById(id: Long): ExerciseEntity?

    @Insert
    suspend fun insert(exercise: ExerciseEntity)

    @Update
    suspend fun update(exercise: ExerciseEntity)

    @Query("delete from exercises where id = :id")
    suspend fun deleteById(id: Long)
}
