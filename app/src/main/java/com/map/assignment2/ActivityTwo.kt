package com.map.assignment2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val tvWelcomeMessage = findViewById<TextView>(R.id.tvWelcomeMessage)

        // FragmentTwo에서 전달된 데이터 받기
        val name = intent.getStringExtra("name") ?: "Guest"

        // 화면에 환영 메시지 표시
        tvWelcomeMessage.text = "Welcome to Activity Two, $name!"
    }
}
