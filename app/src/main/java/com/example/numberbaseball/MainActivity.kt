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
	lateinit var input:EditText
	lateinit var checkButton: Button
	// 정답 리스트
	private var answer:MutableList<Int> = makeNumber()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		input = findViewById(R.id.input)
		checkButton = findViewById(R.id.check)
		checkButton.setOnClickListener {
			//숫자를 입력하지 않았을 때
			if (input.text.toString().isEmpty()){
				Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show()
				return@setOnClickListener
			}
			var number = input.text.toString().toInt()
			//숫자 유효성 검사
			if (checkPredictingNumber(number)){

			}
		}

	}
	// 중복되지 않은 숫자 생성
	fun makeNumber():MutableList<Int>{
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
		return mutableListOf<Int>(first, second, third)
	}
	//예측한 숫자가 유효한지 확인
	fun checkPredictingNumber(predictingNumber:Int):Boolean{
		if (predictingNumber>999 || predictingNumber<100){
			Toast.makeText(this, "숫자를 3자리로 입력해주세요", Toast.LENGTH_SHORT).show()
			return false
		}
		return true
	}

	fun judgeBallAndStrike(predictingNumber:Int):MutableList<Int>{
		var ball = 0
		var strike = 0
		var number = predictingNumber
		// 정답의 각 자리
		var first = answer / 100
		var second = answer % 100 / 10
		var third = answer % 10

	}

}