package com.example.hotels_test_task.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.data.utils.Constants
import com.example.hotels_test_task.R
import com.example.hotels_test_task.databinding.ActivityMainBinding
import com.example.hotels_test_task.screens.hotel.HotelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), HotelFragment.OnDataPass {

    private val TAG = MainActivity::class.simpleName

    private val viewModel : MainActivityVM by viewModels()

    private lateinit var binding : ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    private lateinit var toolbarTitle: TextView
    private lateinit var toolbarBackButton: ImageView

    private lateinit var hotelName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        toolbarBackButton = findViewById<ImageView>(R.id.toolbar_back_button)

        setupNavigation()

        toolbarBackButton.setOnClickListener {
            navController.popBackStack()
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.hotelFragment -> {
                    toolbarTitle.text = resources.getString(R.string.hotel)
                    toolbarBackButton.visibility = View.GONE
                }
                R.id.bookingFragment -> {
                    toolbarTitle.text = resources.getString(R.string.booking)
                }
                R.id.paidInfoFragment -> {
                    toolbarTitle.text = resources.getString(R.string.order_paid)
                }
                R.id.roomsFragment -> {
                    toolbarTitle.text = hotelName
                    toolbarBackButton.visibility = View.VISIBLE
                }
                else -> {

                }
            }
        }
    }

    private fun setupNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onDataPass(data: String) {
        hotelName = data
    }
}