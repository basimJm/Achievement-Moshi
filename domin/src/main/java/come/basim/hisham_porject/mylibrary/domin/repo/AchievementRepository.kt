package come.basim.hisham_porject.mylibrary.domin.repo

import come.basim.hisham_porject.features.domin.model.AchievementModel

interface AchievementRepository {

    suspend fun getAchievement(): List<AchievementModel>
}