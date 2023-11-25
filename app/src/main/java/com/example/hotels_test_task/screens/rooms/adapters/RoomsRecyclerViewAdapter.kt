package com.example.hotels_test_task.screens.rooms.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.ItemRoomsBinding
import com.example.hotels_test_task.models.rooms.RoomPresentation
import com.example.hotels_test_task.screens.hotel.adapters.HotelRecyclerViewAdapter
import com.example.hotels_test_task.screens.hotel.adapters.ImageSliderAdapter
import com.google.android.flexbox.FlexboxLayoutManager

class RoomsRecyclerViewAdapter(
    private val roomsList: List<RoomPresentation>,
    private val context : Context
) : RecyclerView.Adapter<RoomsRecyclerViewAdapter.RoomsHolder>() {

    var onItemClick : ((Int) -> Unit)? = null

    inner class RoomsHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ItemRoomsBinding.bind(item)

        fun bind(room: RoomPresentation) = with(binding) {

            val roomsImageSlideAdapter = ImageSliderAdapter(context, room.image_urls)
            itemRoomsViewpager.adapter= roomsImageSlideAdapter
            itemRoomsIndicator.setViewPager(itemRoomsViewpager)

            itemRoomsRoomName.text = room.name

            val peculiaritiesAdapter = HotelRecyclerViewAdapter(room.peculiarities)
            itemRoomsPeculiaritiesRv.layoutManager = FlexboxLayoutManager(context)
            itemRoomsPeculiaritiesRv.isNestedScrollingEnabled = false
            itemRoomsPeculiaritiesRv.adapter = peculiaritiesAdapter

            itemRoomsPrice.text = context.resources.getString(R.string.price, room.price.toString())
            itemRoomsPricePer.text = room.price_per

            itemRoomsMoreAboutRoomButton.setOnClickListener {
                // кнопка по ТЗ
            }

            itemRoomsChooseRoomButton.setOnClickListener {
                onItemClick?.invoke(room.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomsRecyclerViewAdapter.RoomsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_rooms,
                parent,
                false
            )
        return RoomsHolder(view)
    }

    override fun onBindViewHolder(holder: RoomsRecyclerViewAdapter.RoomsHolder, position: Int) {
        holder.bind(roomsList[position])
    }

    override fun getItemCount(): Int {
        return roomsList.size
    }

}