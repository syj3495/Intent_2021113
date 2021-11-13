package com.neppplus.intent_2021113

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        btnReturnToMain.setOnClickListener {

//            연습문제. 메인으로 돌아가게

            val ReTurnIntent = Intent( this , MainActivity::class.java)
            startActivity(ReTurnIntent)

        }


    }
}