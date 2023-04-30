package come.basim.hisham_porject.features.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import come.basim.hisham_porject.features.databinding.RowMedalBinding
import come.basim.hisham_porject.features.domin.model.RecordsModel

class RecordAdapter :
    ListAdapter<RecordsModel, RecordAdapter.RecordViewHolder>(MyDiffCallback()) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecordAdapter.RecordViewHolder {
        val binding = RowMedalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecordViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RecordAdapter.RecordViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    inner class RecordViewHolder(private val binding: RowMedalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: RecordsModel) {
            binding.model = model

        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<RecordsModel>() {
        override fun areItemsTheSame(oldItem: RecordsModel, newItem: RecordsModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecordsModel, newItem: RecordsModel): Boolean {
            return oldItem == newItem
        }

    }


}





