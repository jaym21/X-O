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

    var PLAYER = true
    var TURN_COUNT = 0
    //making a currentBoard array to save current board state every time a move is made
    var currentBoardState = Array(3) {IntArray(3)}

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

        //initializing the current state of board
        initCurrentBoardState()

        //implementing when reset button is clicked
        binding?.btnReset?.setOnClickListener {
            //initializing the board again
            initCurrentBoardState()
            //making reseting turn count
            TURN_COUNT = 0
            PLAYER = true
        }
    }

    private fun initCurrentBoardState() {
        //going through every element inside the array(i.e basically each button)
        for (i in 0..2) {
            for (j in 0..2) {
                currentBoardState[i][j] = -1
                board[i][j]?.isEnabled = true
                board[i][j]?.text = ""
            }
        }
    }

    //handling clicks of button
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn1 -> {
                updateBox(0, 0, PLAYER)
            }
            R.id.btn2 -> {
                updateBox(0, 1, PLAYER)
            }
            R.id.btn3 -> {
                updateBox(0, 2, PLAYER)
            }
            R.id.btn4 -> {
                updateBox(1, 0, PLAYER)
            }
            R.id.btn5 -> {
                updateBox(1, 1, PLAYER)
            }
            R.id.btn6 -> {
                updateBox(1, 2, PLAYER)
            }
            R.id.btn7 -> {
                updateBox(2, 0, PLAYER)
            }
            R.id.btn8 -> {
                updateBox(2, 1, PLAYER)
            }
            R.id.btn9 -> {
                updateBox(2, 2, PLAYER)
            }
        }
    }

    private fun updateBox(row: Int, col: Int, player: Boolean) {
        val symbol  = if (player) "X" else "O"
        val value = if (player) 1 else 0
        //changing the box(button) text according to the row and col and player(X or O)
        board[row][col]?.text = symbol
        //disabling that button so it cannot be clicked again
        board[row][col]?.isEnabled = false
        //changing current board state by changing the value of the that element in the array according to the player
        currentBoardState[row][col] = value
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}