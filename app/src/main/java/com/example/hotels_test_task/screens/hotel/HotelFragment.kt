package com.example.hotels_test_task.screens.hotel

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.FragmentHotelBinding
import com.example.hotels_test_task.screens.hotel.adapters.ImageSliderAdapter
import com.example.hotels_test_task.screens.hotel.adapters.HotelRecyclerViewAdapter
import com.google.android.flexbox.FlexboxLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelFragment : Fragment() {

    private val TAG = HotelFragment::class.simpleName

    private val viewModel : HotelVM by viewModels()

    private lateinit var binding : FragmentHotelBinding

    var dataPasser: OnDataPass? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            hotelFragmentHotelAddress.setOnClickListener {
                // кнопка по ТЗ
            }

            hotelFragmentComfortsButton.setOnClickListener {
                // кнопка по ТЗ
            }

            hotelFragmentWhatInButton.setOnClickListener {
                // кнопка по ТЗ
            }

            hotelFragmentWhatNotInButton.setOnClickListener {
                // кнопка по ТЗ
            }

            hotelFragmentToRoomButton.setOnClickListener {

                val hotelName = viewModel.getHotelName

                Log.d(TAG, hotelName)
                passData(hotelName)

                findNavController().navigate(R.id.action_hotelFragment_to_roomsFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getHotelInfo.observe(viewLifecycleOwner) {

            binding.apply {

                val hotelImageSlideAdapter = ImageSliderAdapter(requireContext(), it.image_urls)
                hotelFragmentViewpager.adapter = hotelImageSlideAdapter
                hotelFragmentIndicator.setViewPager(hotelFragmentViewpager)

                hotelFragmentRating.text = it.rating.toString()
                hotelFragmentRatingName.text = it.rating_name

                hotelFragmentHotelName.text = it.name
                hotelFragmentHotelAddress.text = it.address

                hotelFragmentMinimalPrice.text = resources.getString(R.string.minimal_price, it.minimal_price.toString())
                hotelFragmentPriceForIt.text = it.price_for_it

                val peculiaritiesAdapter = HotelRecyclerViewAdapter(it.about_the_hotel.peculiarities)
                hotelFragmentRvPeculiarities.layoutManager = FlexboxLayoutManager(requireContext())
                hotelFragmentRvPeculiarities.isNestedScrollingEnabled = false
                hotelFragmentRvPeculiarities.adapter = peculiaritiesAdapter

                hotelFragmentDescription.text = it.about_the_hotel.description

                Log.d(TAG, it.toString())
            }
        }
    }

    interface OnDataPass {
        fun onDataPass(data: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    private fun passData(data: String) {
        dataPasser?.onDataPass(data)
    }
}