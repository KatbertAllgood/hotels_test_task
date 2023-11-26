package com.example.hotels_test_task.screens.booking

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.FragmentBookingBinding
import com.example.hotels_test_task.screens.booking.adapters.TouristsAdapter
import com.example.hotels_test_task.utils.formatNumberWithSpaces
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingFragment : Fragment() {

    private val TAG = BookingFragment::class.simpleName

    private val viewModel : BookingVM by viewModels()

    private lateinit var binding : FragmentBookingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            bookingFragmentAddTouristButton.setOnClickListener {
                viewModel.addTourist("1")
            }

            bookingFragmentPayButton.setOnClickListener {

                findNavController().navigate(R.id.action_bookingFragment_to_paidInfoFragment)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()

        viewModel.getBookingInfo.observe(viewLifecycleOwner) {

            binding.apply {

                bookingFragmentRatingName.text = it.rating_name
                bookingFragmentRating.text = it.horating.toString()
                bookingFragmentHotelName.text = it.hotel_name
                bookingFragmentHotelAddress.text = it.hotel_address
                bookingFragmentDeparture.text = it.departure
                bookingFragmentArrivalCountry.text = it.arrival_country
                bookingFragmentDates.text = "${it.tour_date_start} – ${it.tour_date_stop}"
                bookingFragmentNights.text = resources.getString(R.string.count_nights, it.number_of_nights.toString())
                bookingFragmentHotel.text = it.hotel_name
                bookingFragmentRoom.text = it.room
                bookingFragmentMeals.text = it.nutrition
                bookingFragmentTourPrice.text = resources.getString(R.string.price, formatNumberWithSpaces(it.tour_price))
                bookingFragmentFuelFee.text = resources.getString(R.string.price, formatNumberWithSpaces(it.fuel_charge))
                bookingFragmentServiceFee.text = resources.getString(R.string.price, formatNumberWithSpaces(it.service_charge))
                val full_price = it.tour_price + it.fuel_charge + it.service_charge
                bookingFragmentToBePaid.text = resources.getString(R.string.price, formatNumberWithSpaces(full_price))
                bookingFragmentPayButton.text = resources.getString(R.string.pay_sum, formatNumberWithSpaces(full_price))
            }
        }

        viewModel.getTourists.observe(viewLifecycleOwner) {

            binding.apply {

                val touristsAdapter = TouristsAdapter(it, requireContext())
                bookingFragmentRvTourists.layoutManager = LinearLayoutManager(requireContext())
                bookingFragmentRvTourists.isNestedScrollingEnabled = false
                bookingFragmentRvTourists.adapter = touristsAdapter
            }
        }
    }

}