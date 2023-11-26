package com.example.hotels_test_task.screens.booking.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.ItemTouristBinding

class TouristsAdapter(
    private val touristsList: List<String>,
    private val context: Context
) : RecyclerView.Adapter<TouristsAdapter.TouristsHolder>() {

    inner class TouristsHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ItemTouristBinding.bind(item)

        private val isVisible = false

        @SuppressLint("NotifyDataSetChanged")
        fun bind(tourist: String, position: Int) = with(binding) {

            itemTouristButtonForMore.setOnClickListener {

                when(position + 1) {
                    1 -> itemTouristNumber.text = "Первый турист"
                    2 -> itemTouristNumber.text = "Второй турист"
                    3 -> itemTouristNumber.text = "Третий турист"
                    4 -> itemTouristNumber.text = "Четвертый турист"
                    5 -> itemTouristNumber.text = "Пятый турист"
                    else -> {
                        itemTouristNumber.text = "Неопознанный турист"
                    }
                }

                if (isVisible) {
                    itemTouristButtonForMore.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_hide_button))
                    itemTouristMore.visibility = View.GONE
                } else {
                    itemTouristButtonForMore.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_show_button))
                    itemTouristMore.visibility = View.VISIBLE
                }

                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TouristsAdapter.TouristsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_tourist,
                parent,
                false
            )
        return TouristsHolder(view)
    }

    override fun onBindViewHolder(holder: TouristsAdapter.TouristsHolder, position: Int) {
        holder.bind(touristsList[position], position)
    }

    override fun getItemCount(): Int {
        return touristsList.size
    }

}