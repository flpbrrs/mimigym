package com.flpbrrs.mimigym.core.database.exercise

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    @ColumnInfo(name = "muscle_group") val muscleGroup: String,
    @ColumnInfo(name = "created_at") val createdAt: Long
)