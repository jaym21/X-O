package dev.jaym.xno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.jaym.xno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnStart?.setOnClickListener {
            startActivity(Intent(this, Game::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}