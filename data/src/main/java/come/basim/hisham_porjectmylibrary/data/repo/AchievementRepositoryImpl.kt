package come.basim.hisham_porject.features.data.repo

import come.basim.hisham_porject.features.domin.model.AchievementModel
import come.basim.hisham_porject.mylibrary.domin.repo.AchievementRepository
import come.basim.hisham_porjectmylibrary.data.datasource.AchievementDataSource
import come.basim.hisham_porjectmylibrary.data.mapper.AchievementMapper
import javax.inject.Inject

internal class AchievementRepositoryImpl @Inject constructor(
    private val achievementDataSource: AchievementDataSource,
    private val achievementMapper: AchievementMapper,
) : AchievementRepository {

    override suspend fun getAchievement(): List<AchievementModel> {
        return achievementMapper.mapList(achievementDataSource.getAchievement())
    }
}