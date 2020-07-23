package com.idn99.project.intent.activity_receive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.idn99.project.intent.R
import com.idn99.project.intent.model.Person

class ActivityMoveDataClass : AppCompatActivity() {

    companion object{
        const val WITH_OBJECT = "with_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data_class)

        val tvText : TextView = findViewById(R.id.tv_move_class)

        val person = intent.getParcelableExtra(WITH_OBJECT) as Person

        val text = "Nama Anda : ${person.name} \n Umur Anda : ${person.age} \n Email Anda : ${person.email} \n Alamat Anda : ${person.address}"

        tvText.text = text

    }
}
