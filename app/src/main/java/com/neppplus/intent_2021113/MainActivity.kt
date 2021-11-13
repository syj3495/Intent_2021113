package com.neppplus.intent_2021113

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    멤버변수
    val REQ_FOR_NICKNAME = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnMoveToOther.setOnClickListener {

//              OtherActivity 화면으로 이동하기.

            val myIntent = Intent( this , OtherActivity::class.java )
            startActivity(myIntent)


        }

        btnSendMessage.setOnClickListener {

//            ViewMessageActivity 화면으로 이동하기 + 입력한 문구도 가지고 이동하기

//            1. 입력한 내용을 기록해두자 (변수에 담아두자)

            val inputMessage = edtMessage.text.toString()

//            2. 화면이동

            val myIntent = Intent( this , ViewMessageActivity::class.java)
//              inputMessage에 담긴 내용을 myIntent에 첨부

            myIntent.putExtra("message",inputMessage)

            startActivity(myIntent)



        }

        btnEditNickname.setOnClickListener {

            val myintent = Intent(this, EditNicknameActivity::class.java)

//            닉네임을 받기 위한 왕복이다. -> 왜 가는지를 구별해여ㅑ
//            구별에 사용하는 숫자 -> Request_code라고 부름.

            startActivityForResult(myintent, REQ_FOR_NICKNAME)




        }
    }
}