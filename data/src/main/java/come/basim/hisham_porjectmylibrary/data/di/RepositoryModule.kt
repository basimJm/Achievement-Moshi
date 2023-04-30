package come.basim.hisham_porjectmylibrary.data.di

import come.basim.hisham_porject.features.data.repo.AchievementRepositoryImpl
import come.basim.hisham_porject.mylibrary.domin.repo.AchievementRepository
import come.basim.hisham_porjectmylibrary.data.datasource.AchievementDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

   @Binds
   @Singleton
    fun BindRepository(achievementRepositoryImpl: AchievementRepositoryImpl ): AchievementRepository


}