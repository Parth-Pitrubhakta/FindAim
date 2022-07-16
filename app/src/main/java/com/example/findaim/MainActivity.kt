package com.example.findaim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.findaim.databinding.ActivityMainBinding
import com.example.findaim.ui.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Initialize the bottom navigation view
        //create bottom navigation view object
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigatinView.setupWithNavController(navController)
        binding.bottomNavigatinView.itemIconTintList

//        val bottomNavigationView = findViewById<BottomNavigationView
//                >(R.id.bottom_navigatin_view)
//        val navController = findNavController(R.id.nav_fragment)
//        bottomNavigationView.setupWithNavController(navController
//        )
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}