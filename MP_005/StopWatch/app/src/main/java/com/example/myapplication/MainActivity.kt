package com.example.myapplication

import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pauseTime: Long = 0L

    // 뒤로가기 두 번 클릭을 위한 시간 기록 변수
    private var backPressedTime: Long = 0L
    private val BACK_PRESS_INTERVAL: Long = 2000L // 2초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start 버튼
        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()

            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
        }

        // Stop 버튼
        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true
        }

        // Reset 버튼
        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
        }
    }

    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - backPressedTime < BACK_PRESS_INTERVAL) {
            super.onBackPressed()
        } else {
            backPressedTime = currentTime
            Toast.makeText(this, "종료하려면 한 번 더 누르세요!!", Toast.LENGTH_SHORT).show()
        }
    }
}