package come.basim.hisham_porject.features.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.basim.hisham_porject.features.domin.model.AchievementModel
import come.basim.hisham_porject.features.domin.usecase.AchievementUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val achievementUseCase: AchievementUseCase) :
    ViewModel() {

    //success
    private val _successStateFlow: MutableStateFlow<List<AchievementModel>> = MutableStateFlow(
        emptyList()
    )
    val successStateFlow: StateFlow<List<AchievementModel>> = _successStateFlow

    //loading
    private val _loadingStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val loadingStateFlow = _loadingStateFlow.asStateFlow()

    //erorr

    private val _errorStateFlow: MutableStateFlow<Exception?> = MutableStateFlow(null)

    val errorStateFlow = _errorStateFlow.asStateFlow()

    init {
        getAchievement()
    }

    fun getAchievement() {
        viewModelScope.launch {
            _loadingStateFlow.emit(true)
            try {
                _successStateFlow.emit(achievementUseCase())
            } catch (e: Exception) {
                _errorStateFlow.emit(e)
            }
            _loadingStateFlow.emit(false)
        }
    }
}