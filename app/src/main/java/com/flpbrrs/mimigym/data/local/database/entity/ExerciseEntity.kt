package com.flpbrrs.mimigym.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "training_id")
    val trainingId: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Float
)
