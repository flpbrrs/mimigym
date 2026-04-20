package com.flpbrrs.mimigym.features.home.data.repository

import com.flpbrrs.mimigym.core.database.session.SessionDao
import com.flpbrrs.mimigym.core.database.template.TemplateDao
import com.flpbrrs.mimigym.core.database.template.TemplateWorkoutEntity
import com.flpbrrs.mimigym.core.database.template.WeeklyScheduleEntity
import com.flpbrrs.mimigym.features.home.domain.repository.HomeContentRepository

class HomeContentRepositoryImpl(
    private val templateDao: TemplateDao,
    private val sessionDao: SessionDao,
) : HomeContentRepository {

    //    override suspend fun getCurrentWeekSchedule(): List<WeekDaySchedule> = listOf(
//        WeekDaySchedule(
//            label = "DOM",
//            template = "Lo. A",
//            trainingInfo = TrainingDayInfo.Completed(sessionId = 1)
//        ),
//        WeekDaySchedule(
//            label = "SEG",
//            template = "Rest",
//            trainingInfo = TrainingDayInfo.Rest
//        ),
//        WeekDaySchedule(
//            label = "TER",
//            template = "Up. B",
//            trainingInfo = TrainingDayInfo.Completed(sessionId = 2)
//        ),
//        WeekDaySchedule(
//            label = "QUA",
//            template = "Rest",
//            trainingInfo = TrainingDayInfo.Rest
//        ),
//        WeekDaySchedule(
//            label = "QUI",
//            template = "Lo. B",
//            trainingInfo = TrainingDayInfo.Today(templateId = 3)
//        ),
//        WeekDaySchedule(
//            label = "SEX",
//            template = "Rest",
//            trainingInfo = TrainingDayInfo.Rest
//        ),
//        WeekDaySchedule(
//            label = "SAB",
//            template = "Up. A",
//            trainingInfo = TrainingDayInfo.Upcoming(templateId = 4)
//        )
//    )
    override suspend fun getCurrentWeekSchedule(): List<WeeklyScheduleEntity> =
        templateDao.getWeeklySchedule()

    override suspend fun getAllTemplateWorkouts(): List<TemplateWorkoutEntity> =
        templateDao.getAllTemplateWorkouts()

}
