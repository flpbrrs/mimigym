package com.flpbrrs.mimigym.core.database.session

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.flpbrrs.mimigym.core.database.template.TemplateWorkoutEntity

@Entity(
    tableName = "session_workout",
    foreignKeys = [
        ForeignKey(
            entity = TemplateWorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["template_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("template_id")
    ]
)
data class SessionWorkoutEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "template_id") val templateId: Long,
    @ColumnInfo(name = "started_at") val startedAt: Long,
    @ColumnInfo(name = "finished_at") val finishedAt: Long?,
    val notes: String?,
)
