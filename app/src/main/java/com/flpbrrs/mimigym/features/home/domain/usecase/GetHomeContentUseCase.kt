package com.flpbrrs.mimigym.features.home.domain.usecase

import com.flpbrrs.mimigym.features.home.domain.model.WeekDaySchedule
import com.flpbrrs.mimigym.features.home.domain.repository.HomeContentRepository

class GetHomeContentUseCase(
    private val homeContentRepository: HomeContentRepository
) {
    suspend operator fun invoke(): List<WeekDaySchedule> {
        // TODO: Add business logic for determine current week start and end
        return homeContentRepository.getCurrentWeekSchedule()
    }
}