package com.developermilan.servicesandbackgroundtasks.foregroundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import com.developermilan.servicesandbackgroundtasks.Constants
import com.developermilan.servicesandbackgroundtasks.R
import com.developermilan.servicesandbackgroundtasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startService.setOnClickListener {
            val input = binding.editTextInput.text.toString()

            val myServiceIntent = Intent(this, MyForegroundService::class.java)
            myServiceIntent.putExtra(Constants.inputExtra, input)
            ContextCompat.startForegroundService(this, myServiceIntent)
        }
        binding.stopService.setOnClickListener {
            val serviceIntent = Intent(this, MyForegroundService::class.java)
            stopService(serviceIntent)
        }
    }

    override fun onResume() {
        super.onResume()
    }
}