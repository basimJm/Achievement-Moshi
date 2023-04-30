package come.basim.hisham_porjectmylibrary.data.datasource

import com.runkeeper.achievement.feature.home.data.remote.model.RemoteAchievementResponse
import com.serjltt.moshi.adapters.Wrapped
import retrofit2.http.GET

internal interface AchievementDataSource{

    @GET("/achievements")
    @Wrapped(path = ["data"])
    suspend fun getAchievement(): List<RemoteAchievementResponse>

}