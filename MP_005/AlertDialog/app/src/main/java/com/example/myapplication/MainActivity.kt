package com.example.myapplication

import android.app.*
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val TAG = "kkang"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 날짜 선택 다이얼로그
        findViewById<Button>(R.id.btnDatePicker).setOnClickListener {
            DatePickerDialog(this, { _, year, month, dayOfMonth ->
                Log.d(TAG, "year : $year, month : ${month + 1}, dayOfMonth : $dayOfMonth")
            }, 2024, 4, 6).show()
        }

        // 시간 선택 다이얼로그
        findViewById<Button>(R.id.btnTimePicker).setOnClickListener {
            TimePickerDialog(this, { _, hourOfDay, minute ->
                Log.d(TAG, "time : $hourOfDay, minute : $minute")
            }, 15, 0, true).show()
        }

        // 기본 알림창
        findViewById<Button>(R.id.btnAlert).setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("test dialog")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                setPositiveButton("OK", null)
                setNegativeButton("Cancel", null)
                setNeutralButton("More", null)
                show()
            }
        }

        // 버튼 이벤트 핸들러 알림창
        findViewById<Button>(R.id.btnAlertWithHandler).setOnClickListener {
            val handler = DialogInterface.OnClickListener { _, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> Log.d(TAG, "positive button click")
                    DialogInterface.BUTTON_NEGATIVE -> Log.d(TAG, "negative button click")
                }
            }

            AlertDialog.Builder(this).run {
                setTitle("Handled Dialog")
                setPositiveButton("OK", handler)
                setNegativeButton("Cancel", handler)
                show()
            }
        }

        // 리스트 알림창
        findViewById<Button>(R.id.btnListDialog).setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setItems(items) { _, which ->
                    Log.d(TAG, "선택한 과일 : ${items[which]}")
                }
                setPositiveButton("닫기", null)
                show()
            }
        }

        // 다중 선택 알림창
        findViewById<Button>(R.id.btnMultiChoice).setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            val checked = booleanArrayOf(true, false, true, false)
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setMultiChoiceItems(items, checked) { _, which, isChecked ->
                    Log.d(TAG, "${items[which]} ${if (isChecked) "선택됨" else "해제됨"}")
                }
                setPositiveButton("닫기", null)
                show()
            }
        }

        // 단일 선택 알림창
        findViewById<Button>(R.id.btnSingleChoice).setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setSingleChoiceItems(items, 1) { _, which ->
                    Log.d(TAG, "${items[which]} 이 선택되었습니다.")
                }
                setPositiveButton("닫기", null)
                show()
            }
        }

        // 닫힘 제어 알림창
        findViewById<Button>(R.id.btnCancelableDialog).setOnClickListener {
            val items = arrayOf("사과", "복숭아", "수박", "딸기")
            val dialog = AlertDialog.Builder(this).run {
                setTitle("items test")
                setItems(items) { _, which ->
                    Log.d(TAG, "선택한 과일 : ${items[which]}")
                }
                setPositiveButton("닫기", null)
                setCancelable(false)
                show()
            }
            dialog.setCanceledOnTouchOutside(false)
        }
    }
}
