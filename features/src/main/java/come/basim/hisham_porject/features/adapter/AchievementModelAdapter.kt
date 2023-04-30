package come.basim.hisham_porject.features.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import come.basim.hisham_porject.features.databinding.RowSectionAchievementBinding
import come.basim.hisham_porject.features.domin.model.AchievementModel

class AchievementModelAdapter :
    ListAdapter<AchievementModel, AchievementModelAdapter.AchievementViewHolder>(MyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        val binding =
            RowSectionAchievementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AchievementViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AchievementViewHolder(private val binding: RowSectionAchievementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val recordAdapter = RecordAdapter()

        fun bind(model: AchievementModel) {
            binding.model = model

            binding.executePendingBindings()

            recordAdapter.submitList(model.records)
            binding.recyclerViewMedal.adapter = recordAdapter


        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<AchievementModel>() {
        override fun areItemsTheSame(
            oldItem: AchievementModel,
            newItem: AchievementModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: AchievementModel,
            newItem: AchievementModel
        ): Boolean {
            return oldItem == newItem
        }

    }


}

