package agency.five.codebase.android.movieapp.data.di

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.logging.*
import org.koin.dsl.module

val networkModule = module {

    single<MovieService> { MovieServiceImpl(client = get()) }

    single {
        HttpClient(Android) {
            engine {
                connectTimeout = 10000
                socketTimeout = 10000
            }
            install(Logging)
        }
    }
}
