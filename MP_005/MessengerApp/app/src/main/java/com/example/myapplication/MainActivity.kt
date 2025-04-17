package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼을 클릭했을 때 이벤트
        binding.turnOnButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.turn_on) + " clicked", Toast.LENGTH_SHORT).show()
        }
        // 버튼을 클릭했을 때 이벤트
        binding.notNowButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.not_now) + " clicked", Toast.LENGTH_SHORT).show()
        }
    }
}