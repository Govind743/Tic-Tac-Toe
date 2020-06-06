package com.example.tictactoe

/**
 * Created by Govind Yadav on 01-06-2020.
 */

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageView

class MainActivity : AppCompatActivity() {

    enum class PLAYINGPLAYER{
        FIRST_PLAYER,
        SECOND_PLAYER
    }

    enum class WINNER {
        PLAYER_ONE,
        PLAYER_TWO,
        NO_ONE
    }

    //Instance variables
    var playingplayer: PLAYINGPLAYER?= null
    var winner: WINNER?= null

    var player1Option= ArrayList<Int>()
    var player2Option= ArrayList<Int>()
    var allDisabledImages= ArrayList<ImageButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        playingplayer = PLAYINGPLAYER.FIRST_PLAYER
    }

    fun imgButtonClicked(view: View) {
        val selectedImageButton: ImageButton= view as ImageButton
        var optionNumber= 0

        when(selectedImageButton.id)
        {
            R.id.imageButton1 -> optionNumber = 1
            R.id.imageButton2 -> optionNumber = 2
            R.id.imageButton3 -> optionNumber = 3
            R.id.imageButton4 -> optionNumber = 4
            R.id.imageButton5 -> optionNumber = 5
            R.id.imageButton6 -> optionNumber = 6
            R.id.imageButton7 -> optionNumber = 7
            R.id.imageButton8 -> optionNumber = 8
            R.id.imageButton9 -> optionNumber = 9
        }

        action(optionNumber, selectedImageButton)
    }

    private fun action(optionNumber: Int, selectedImageButton: ImageButton) {

        if(playingplayer == PLAYINGPLAYER.FIRST_PLAYER){
            selectedImageButton.setImageResource(R.drawable.x)
            player1Option.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingplayer = PLAYINGPLAYER.SECOND_PLAYER
        }

        else if(playingplayer == PLAYINGPLAYER.SECOND_PLAYER){
            selectedImageButton.setImageResource(R.drawable.zero)
            player2Option.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingplayer = PLAYINGPLAYER.FIRST_PLAYER
        }

        specifyWinner()
    }

    private fun specifyWinner() {
        if(player1Option.contains(1)&& player1Option.contains(2) && player1Option.contains(3)){

            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(1) && player2Option.contains(2) && player2Option.contains(3))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(4)&& player1Option.contains(5) && player1Option.contains(6))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(4) && player2Option.contains(5) && player2Option.contains(6))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(7)&& player1Option.contains(8) && player1Option.contains(9))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(7) && player2Option.contains(8) && player2Option.contains(9))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(1) && player1Option.contains(4) && player1Option.contains(7))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(1) && player2Option.contains(4) && player2Option.contains(7))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(2) && player1Option.contains(5) && player1Option.contains(8))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(2) && player2Option.contains(5) && player2Option.contains(8))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(3) && player1Option.contains(6) && player1Option.contains(9))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(3) && player2Option.contains(6) && player2Option.contains(9))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(1) && player1Option.contains(5) && player1Option.contains(9))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(1) && player2Option.contains(5) && player2Option.contains(9))
        {
            winner= WINNER.PLAYER_TWO
        }
        else if(player1Option.contains(3) && player1Option.contains(5) && player1Option.contains(7))
        {
            winner= WINNER.PLAYER_ONE
        }
        else if(player2Option.contains(3) && player2Option.contains(5) && player2Option.contains(7))
        {
            winner= WINNER.PLAYER_TWO
        }

        if(winner== WINNER.PLAYER_ONE){
            createAlert("Player1 wins", "Congratulations to Player1", AlertDialog.BUTTON_POSITIVE, "OK", false)
            return
        }
        else if(winner== WINNER.PLAYER_TWO){
            createAlert("Player2 wins", "Congratulations to Player2", AlertDialog.BUTTON_POSITIVE, "OK", false)
        }

    }

    private fun createAlert(title: String, msg: String, btnState: Int, btnText: String, btnCancel: Boolean) {
        val alertDialog: AlertDialog =
            AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(msg)

        alertDialog.setButton(btnState, btnText, {
                dialog: DialogInterface?, which: Int ->


            resetGame()

        })
        alertDialog.setCancelable(btnCancel)

        alertDialog.show()
    }
}