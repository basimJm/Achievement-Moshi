package come.basim.hisham_porjectmylibrary.data.di

import come.basim.hisham_porjectmylibrary.data.datasource.AchievementDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    @Singleton
    fun provideDataSource(retrofit: Retrofit): AchievementDataSource {
        return retrofit.create()  //try::class.java
    }
}