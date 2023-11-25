package com.example.hotels_test_task.screens.hotel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.ItemPeculiaritiesBinding

class HotelRecyclerViewAdapter(
    private val peculiaritiesList: List<String>
) : RecyclerView.Adapter<HotelRecyclerViewAdapter.PeculiaritiesHolder>() {

    inner class PeculiaritiesHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ItemPeculiaritiesBinding.bind(item)

        fun bind(peculiaritie: String) = with(binding) {

            itemPeculiaritiesName.text = peculiaritie
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HotelRecyclerViewAdapter.PeculiaritiesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_peculiarities,
                parent,
                false
            )
        return PeculiaritiesHolder(view)
    }

    override fun getItemCount(): Int {
        return peculiaritiesList.size
    }

    override fun onBindViewHolder(
        holder: HotelRecyclerViewAdapter.PeculiaritiesHolder,
        position: Int
    ) {
        holder.bind(peculiaritiesList[position])
    }
}