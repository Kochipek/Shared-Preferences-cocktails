package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigationView

        setupNavigationUI(bottomNavigationView)
        setupActionBar()
        setToolbarTitle()

        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupNavigationUI(bottomNavigationView: BottomNavigationView) {
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    private fun setupActionBar() {
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    private fun setToolbarTitle() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbarTitle.text = destination.label
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
