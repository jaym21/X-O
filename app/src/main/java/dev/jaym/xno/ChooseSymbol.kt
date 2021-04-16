package dev.jaym.xno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.jaym.xno.databinding.ActivityChooseSymbolBinding

class ChooseSymbol : AppCompatActivity() {

    var binding: ActivityChooseSymbolBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseSymbolBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnX?.setOnClickListener {
            val intentX = Intent(this, Game::class.java)
            intentX.putExtra("SYMBOL", "X")
            startActivity(intentX)
            finish()
        }

        binding?.btnO?.setOnClickListener {
            val intentO = Intent(this, Game::class.java)
            intentO.putExtra("SYMBOL", "O")
            startActivity(intentO)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}