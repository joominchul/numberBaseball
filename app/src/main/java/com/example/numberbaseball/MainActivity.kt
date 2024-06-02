package com.example.numberbaseball

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	//숫자 범위
	private val RANGE = (1..9)
	//예측한 숫자
	lateinit var predictingNumber:EditText
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		predictingNumber = findViewById(R.id.input)
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

		}
	}
	//예측한 숫자가 유효한지 확인
	fun checkPredictingNumber(predictingNumber:EditText):Int{
		var predictingNumber = predictingNumber.text.toString().toInt()
		if (Math.pow(10.0, predictingNumber.toDouble()-1)>predictingNumber) error("checkPredictingNumber")
		return predictingNumber
	}

}