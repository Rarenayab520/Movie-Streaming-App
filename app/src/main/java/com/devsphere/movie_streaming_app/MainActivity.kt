package com.devsphere.movie_streaming_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the modern theme programmatically if needed
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Yahan hum baad mein Adapter attach karenge jo Internet Archive API se data lega [cite: 46]
    }
}