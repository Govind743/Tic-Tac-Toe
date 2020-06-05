package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}