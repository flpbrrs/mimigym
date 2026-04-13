package com.flpbrrs.mimigym.features.home.di

import com.flpbrrs.mimigym.features.home.data.repository.HomeContentRepositoryImpl
import com.flpbrrs.mimigym.features.home.domain.repository.HomeContentRepository
import com.flpbrrs.mimigym.features.home.domain.usecase.GetHomeContentUseCase
import com.flpbrrs.mimigym.features.home.presentation.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object HomeModule {
    val data = module {
        singleOf(::HomeContentRepositoryImpl) {
            bind<HomeContentRepository>()
        }
    }

    val domain = module {
        factoryOf(::GetHomeContentUseCase)
    }

    val ui = module {
        viewModelOf(::HomeViewModel)
    }
}