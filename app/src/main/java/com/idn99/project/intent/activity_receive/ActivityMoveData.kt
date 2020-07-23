package com.idn99.project.intent.activity_receive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.idn99.project.intent.R

class ActivityMoveData : AppCompatActivity() {

    companion object{
        const val NAMA_TEXT = "nama_text"
        const val AGE_TEXT = "age_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        val tvMove : TextView = findViewById(R.id.tv_move)

        val name = intent.getStringExtra(NAMA_TEXT)
        val age = intent.getIntExtra(AGE_TEXT, 0)

        val text = "Nama Anda : $name \n Umur Anda : $age"

        tvMove.text = text

    }
}
