package com.flpbrrs.mimigym.core.database.template

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "template_workout")
data class TemplateWorkoutEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val description: String?,
    @ColumnInfo(name = "created_at") val createdAt: Long,
)