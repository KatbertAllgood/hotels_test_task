package com.example.hotels_test_task.screens.paid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.FragmentPaidInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaidInfoFragment : Fragment() {

    private val TAG = PaidInfoFragment::class.simpleName

    private lateinit var binding : FragmentPaidInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaidInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.paidFragmentSuperButton.setOnClickListener {

            findNavController().popBackStack(R.id.hotelFragment, false)
            findNavController().navigate(R.id.hotelFragment)
        }
    }
}