package com.example.numberbaseball

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	//숫자 범위
	private val RANGE = (1..9)
	//예측한 숫자
	lateinit var predictingNumber:EditText
	lateinit var checkButton: Button
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		predictingNumber = findViewById(R.id.input)
		checkButton = findViewById(R.id.check)
		checkButton.setOnClickListener {
			Log.d("checkButton", predictingNumber.text.toString().toInt().toString())
		}

	}
	//숫자 생성
	fun makeNumber():Int{
		var first:Int
		var second:Int
		var third:Int

		first = RANGE.random()
		do {
			second = RANGE.random()
		} while (first == second)
		do {
			third = RANGE.random()
		} while (first == third || second == third)
		return first * 100 + second * 10 + third
	}

	fun run(){
		while (true){
			var predictingNumber = checkPredictingNumber(predictingNumber)
		}
	}
	//예측한 숫자가 유효한지 확인
	fun checkPredictingNumber(predictingNumber:EditText):Boolean{
		var predictingNumber = predictingNumber.text.toString().toInt()
		if (predictingNumber>999 || predictingNumber<100){
			Toast.makeText(this, "숫자를 3자리로 입력해주세요", Toast.LENGTH_SHORT).show()
			return false
		}
		return true


	}

}