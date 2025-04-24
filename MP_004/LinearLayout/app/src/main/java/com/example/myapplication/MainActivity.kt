package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    // View 변수 선언
    /* 실습 주석
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var chkAgree: CheckBox
    lateinit var rGroup1: RadioGroup
    lateinit var rdoDog: RadioButton
    lateinit var rdoCat: RadioButton
    lateinit var rdoRabbit: RadioButton
    lateinit var btnOK: Button
    lateinit var imgPet: ImageView

    @SuppressLint("MissingInflatedId")
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linearlayout)
        /* 실습 주석
        title = "애완동물 사진 보기"

        // View 객체 연결
        text1 = findViewById(R.id.Text1)
        text2 = findViewById(R.id.Text2)
        chkAgree = findViewById(R.id.ChkAgree)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoDog = findViewById(R.id.RdoDog)
        rdoCat = findViewById(R.id.RdoCat)
        rdoRabbit = findViewById(R.id.RdoRabbit)
        btnOK = findViewById(R.id.BtnOK)
        imgPet = findViewById(R.id.ImgPet)

        // 체크박스 이벤트 처리
        chkAgree.setOnCheckedChangeListener { _, isChecked ->
            val visibility = if (isChecked) View.VISIBLE else View.INVISIBLE
            text2.visibility = visibility
            rGroup1.visibility = visibility
            btnOK.visibility = visibility
            imgPet.visibility = visibility
        }

        // 버튼 클릭 시 이미지 변경
        btnOK.setOnClickListener {
            when (rGroup1.checkedRadioButtonId) {
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(this, "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
         */
    }
}
