package come.basim.hisham_porject.features.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import come.basim.hisham_porject.features.adapter.AchievementModelAdapter
import come.basim.hisham_porject.features.databinding.FragmentAchievmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentAchievmentBinding

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter: AchievementModelAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAchievmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initForAdapter()
        initObsrevre()
    }

    private fun initForAdapter() {
        initAdapter()
    }

    private fun initObsrevre() {
        initLoading()
        initError()
        initSuccess()
    }

    private fun initSuccess() {
        lifecycleScope.launch {
            viewModel.successStateFlow.collect() { response ->
                adapter.submitList(response)
            }
        }
    }

    fun initAdapter() {
        adapter = AchievementModelAdapter()
        binding.recyclerViewMedal.adapter = adapter
    }

    private fun initError() {
        lifecycleScope.launch {
            viewModel.errorStateFlow.collect() { e ->
                Log.d("TAGOO", "ERROR : $e")
            }
        }
    }

    private fun initLoading() {
        lifecycleScope.launch {
            viewModel.loadingStateFlow.collect() { show ->
                binding.progressBar.isVisible = show
            }
        }
    }

}