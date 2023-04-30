package come.basim.hisham_porject.features.domin.usecase

import come.basim.hisham_porject.features.domin.model.AchievementModel
import come.basim.hisham_porject.mylibrary.domin.repo.AchievementRepository
import javax.inject.Inject

class AchievementUseCase @Inject constructor(private val achievementRepository: AchievementRepository) {
    suspend operator fun invoke(): List<AchievementModel> {
        return achievementRepository.getAchievement()
    }
}