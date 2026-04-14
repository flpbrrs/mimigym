package com.flpbrrs.mimigym.core.database.exercise

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExerciseDao {
    @Query(value = "select * from exercises")
    fun getAll(): List<ExerciseEntity>

    @Query(
        value = """
        select * from exercises where id = :id
    """
    )
    fun getById(id: Long): ExerciseEntity

    @Update
    fun update(exercise: ExerciseEntity)
}
