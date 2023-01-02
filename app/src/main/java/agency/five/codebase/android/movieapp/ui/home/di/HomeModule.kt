package agency.five.codebase.android.movieapp.ui.home.di

import agency.five.codebase.android.movieapp.data.di.BACKGROUND_DISPATCHER
import agency.five.codebase.android.movieapp.ui.home.HomeViewModel
import agency.five.codebase.android.movieapp.ui.home.mapper.HomeScreenMapper
import agency.five.codebase.android.movieapp.ui.home.mapper.HomeScreenMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named

import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(
            movieRepository = get(),
            homeScreenMapper = get(),
            bgDispatcher = get(named(BACKGROUND_DISPATCHER))
        )
    }
    single<HomeScreenMapper> { HomeScreenMapperImpl() }
}
