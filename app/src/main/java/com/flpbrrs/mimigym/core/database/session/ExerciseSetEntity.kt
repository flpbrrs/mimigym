package com.flpbrrs.mimigym.core.database.session

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise_set",
    foreignKeys = [
        ForeignKey(
            entity = SessionExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["session_exercise_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("session_exercise_id")],

)
data class ExerciseSetEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "session_exercise_id") val sessionExerciseId: Long,
    @ColumnInfo(name = "set_type") val setType: String,
    val load: Double,
    val reps: Int,
    val rir: Int?,
    @ColumnInfo(name = "order_index") val orderIndex: Int,
)
