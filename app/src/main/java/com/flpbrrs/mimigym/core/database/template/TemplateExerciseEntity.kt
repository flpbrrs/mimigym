package com.flpbrrs.mimigym.core.database.template

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.flpbrrs.mimigym.core.database.exercise.ExerciseEntity

@Entity(
    tableName = "template_exercise",
    foreignKeys = [
        ForeignKey(
            entity = TemplateWorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["template_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ExerciseEntity::class,
            parentColumns = ["id"],
            childColumns = ["exercise_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index("template_id"),
        Index("exercise_id")
    ]
)
data class TemplateExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "template_id") val templateId: Long,
    @ColumnInfo(name = "exercise_id") val exerciseId: Long,
    @ColumnInfo(name = "order_index") val orderIndex: Int,
    @ColumnInfo(name = "target_load") val targetLoad: Double,
    @ColumnInfo(name = "working_sets_count") val workingSetsCount: Int,
    @ColumnInfo(name = "target_rep_range_min") val targetRepRangeMin: Int,
    @ColumnInfo(name = "target_rep_range_max") val targetRepRangeMax: Int,
)
