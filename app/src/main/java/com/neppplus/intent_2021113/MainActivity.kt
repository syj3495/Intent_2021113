package com.neppplus.intent_2021113

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    멤버변수
    val REQ_FOR_NICKNAME = 1000
    val REQ_FOR_EMAIL = 1001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDial.setOnClickListener {

//            입력한 전화번호? 추출 ( 변수에 저장 )
            val inputPhoneNum = edtPhoneNum.text.toString()

//            그 전화번호에 실제 전화 연결 (DAIL)
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent( Intent.ACTION_DIAL, myUri )
            startActivity(myIntent)



        }


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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        requestCode : 어떤 것을 가지러 다녀온건지 알려주는 숫자가 기록됨

        if ( requestCode == REQ_FOR_NICKNAME) {

//            닉네임을 가지러 다녀왔을 때 실행되는 중괄호

//            resultCode : 확인 (OK) / 취소 (CANCEL) 중 어떤것을 눌렀는 지 알려줌.

            if (resultCode == RESULT_OK ) {

//                닉네임을 가지러가서 -> 확인도 누른게 맞을 때 실행되는 코드.

//                data : 이전 화면에서 담아준 resultIntent를 들고 있는 역할.

                val newNickname = data?.getStringExtra("nick")

                txtNickname.text = newNickname


            }

        }

    }
}