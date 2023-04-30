package come.basim.hisham_porject.features.domin.model

import com.google.gson.Gson

data class AchievementModel(
    val id: Int,

    val title: String,

    val label: String,

    val records: List<RecordsModel>,
)



