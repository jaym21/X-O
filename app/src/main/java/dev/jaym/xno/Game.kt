package dev.jaym.xno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.button.MaterialButton
import dev.jaym.xno.databinding.ActivityGameBinding

class Game : AppCompatActivity(), View.OnClickListener {

    var binding: ActivityGameBinding? = null
    //initializing a array of board which has array of buttons
    lateinit var board: Array<Array<MaterialButton?>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //adding array of buttons inside array of board
        board = arrayOf(
            arrayOf(binding?.btn1, binding?.btn2, binding?.btn3),
            arrayOf(binding?.btn4, binding?.btn5, binding?.btn6),
            arrayOf(binding?.btn7, binding?.btn8, binding?.btn9)
        )

        //handling click of each button using a common onclick listener
        for (i in board) {
            for (btn in i) {
                btn?.setOnClickListener(this)
            }
        }
    }

    //handling clicks of button
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn1 -> {

            }
            R.id.btn2 -> {

            }
            R.id.btn3 -> {

            }
            R.id.btn4 -> {

            }
            R.id.btn5 -> {

            }
            R.id.btn6 -> {

            }
            R.id.btn7 -> {

            }
            R.id.btn8 -> {

            }
            R.id.btn9 -> {

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}