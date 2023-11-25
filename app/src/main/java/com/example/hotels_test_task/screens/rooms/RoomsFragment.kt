package com.example.hotels_test_task.screens.rooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.FragmentRoomsBinding
import com.example.hotels_test_task.screens.rooms.adapters.RoomsRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private val TAG = RoomsFragment::class.simpleName

    private val viewModel : RoomsVM by viewModels()

    private lateinit var binding : FragmentRoomsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllRooms.observe(viewLifecycleOwner) {

            binding.apply {

                val roomsAdapter = RoomsRecyclerViewAdapter(it.rooms, requireContext())
                roomsFragmentRv.layoutManager = LinearLayoutManager(requireContext())
//                roomsFragmentRv.isNestedScrollingEnabled = false

                roomsAdapter.onItemClick = {id ->

                    findNavController().navigate(R.id.action_roomsFragment_to_bookingFragment)
                }

                roomsFragmentRv.adapter = roomsAdapter
            }
        }
    }

}