package com.flpbrrs.mimigym.core.database.template

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "weekly_schedule",
    foreignKeys = [
        ForeignKey(
            entity = TemplateWorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["template_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("template_id")]
)
data class WeeklyScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "day_of_week") val dayOfWeek: Int,
    @ColumnInfo(name = "template_id") val templateId: Long,
)
