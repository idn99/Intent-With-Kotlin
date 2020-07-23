package com.idn99.project.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import com.idn99.project.intent.activity_receive.ActivityMove
import com.idn99.project.intent.activity_receive.ActivityMoveData
import com.idn99.project.intent.activity_receive.ActivityMoveDataClass
import com.idn99.project.intent.activity_receive.ActivityReceive
import com.idn99.project.intent.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tvResult : TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindah : Button = findViewById(R.id.btn_move_activity)
        val btnPindahData : Button = findViewById(R.id.btn_move_activity_with_data)
        val btnPindahClass : Button = findViewById(R.id.btn_move_activity_with_data_class)
        val btnDial : Button = findViewById(R.id.btn_exp_dial)
        val btnAngka : Button = findViewById(R.id.btn_pilih_angka)
        tvResult = findViewById(R.id.tv_result)

        btnPindah.setOnClickListener(this)
        btnPindahData.setOnClickListener(this)
        btnPindahClass.setOnClickListener(this)
        btnDial.setOnClickListener(this)
        btnAngka.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, ActivityMove::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_with_data -> {
                val moveWithData = Intent(this@MainActivity, ActivityMoveData::class.java)
                moveWithData.putExtra(ActivityMoveData.NAMA_TEXT, "Ilham Dwi Nugraha")
                moveWithData.putExtra(ActivityMoveData.AGE_TEXT, 21)
                startActivity(moveWithData)
            }

            R.id.btn_move_activity_with_data_class -> {
                val person = Person(
                    "Ilham Dwi Nugraha",
                    21,
                    "idn99@gmail.com",
                    "Balaraja, Kab. Tangerang, Prov. Banten"
                )

                val moveWithObject = Intent(this@MainActivity, ActivityMoveDataClass::class.java)
                moveWithObject.putExtra(ActivityMoveDataClass.WITH_OBJECT, person)
                startActivity(moveWithObject)
            }

            R.id.btn_exp_dial -> {
                val noTlp = "08871224023"
                val dialNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$noTlp"))
                startActivity(dialNumber)
            }

            R.id.btn_pilih_angka -> {
                val moveForResultIntent = Intent(this@MainActivity, ActivityReceive::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == ActivityReceive.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(ActivityReceive.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}
