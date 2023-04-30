package come.basim.hisham_porjectmylibrary.data.mapper

import com.runkeeper.achievement.feature.home.data.remote.model.RemoteAchievementResponse
import com.runkeeper.achievement.feature.home.data.remote.model.RemoteRecordsResponse
import come.basim.hisham_porject.features.domin.model.AchievementModel
import come.basim.hisham_porject.features.domin.model.RecordsModel
import come.basim.hisham_porject.mapper.Mapper
import javax.inject.Inject

internal class AchievementMapper @Inject constructor() :
    Mapper<RemoteAchievementResponse, AchievementModel> {

    override fun map(source: RemoteAchievementResponse): AchievementModel {
        return AchievementModel(
            id = source.id,
            title = source.title,
            label = source.label,
            records = source.records.map { mapRecords(it) },
        )
    }

    private fun mapRecords(remoteRecordsResponse: RemoteRecordsResponse): RecordsModel {
        return RecordsModel(
            id = remoteRecordsResponse.id,
            title = remoteRecordsResponse.title,
            label = remoteRecordsResponse.label,
            active = remoteRecordsResponse.active,
            image = remoteRecordsResponse.image
        )
    }

}