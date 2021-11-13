package com.neppplus.intent_2021113

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnOK.setOnClickListener {

//            1. 입력할 값을 변수에 저장
            val inputNickname = edtNickname.text.toString()

//            2. 새 닉네임 들고 복귀
            val resultIntent = Intent()
            resultIntent.putExtra("nick",inputNickname)

//            3. 결과 설정 - ok 누른게 맞다고 구별, 들고갈 데이터 첨부
            setResult(RESULT_OK, resultIntent)

//            4. 복귀
            finish()




        }






    }
}