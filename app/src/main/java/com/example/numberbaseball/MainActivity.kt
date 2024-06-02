package com.example.numberbaseball

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	//숫자 범위
	private val RANGE = (1..9)
	//최대 횟수
	private val MAX_COUNT = 10
	//예측한 숫자
	lateinit var input:EditText
	lateinit var checkButton: Button
	// 정답 리스트
	private var answer:MutableList<Int> = makeNumber()
	// 결과 텍스트뷰
	lateinit var resultView: TextView
	// 최소 삼진 시도 횟수
	private var minCount = MAX_COUNT
	// 현재 시도 횟수
	private var nowCount = 0
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		input = findViewById(R.id.input)
		checkButton = findViewById(R.id.check)
		resultView = findViewById(R.id.result)
		checkButton.setOnClickListener {
			//숫자를 입력하지 않았을 때
			if (input.text.toString().isEmpty()){
				Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show()
				return@setOnClickListener
			}
			var number = input.text.toString().toInt()
			//숫자 유효성 검사
			if (checkPredictingNumber(number)){
				showResult(judgeBallAndStrike(number))
				nowCount++
				if (nowCount == MAX_COUNT){
					resultView.text = "최대 횟수(9번) 초과! 게임 종료"
					answer = makeNumber()
					nowCount = 0
					input.setText("") //입력창 초기화
				}
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
	// 정답과 예측한 숫자를 비교
	fun judgeBallAndStrike(predictingNumber:Int):MutableList<Int>{
		var ball = 0
		var strike = 0
		// 정답의 각 자리
		var answerFirst = answer[0]
		var answerSecond = answer[1]
		var answerThird = answer[2]
		// 예측한 숫자의 각 자리
		var inputFirst = predictingNumber/100
		var inputSecond = predictingNumber/10%10
		var inputThird = predictingNumber%10
		// 첫번째 자리 숫자 비교
		if (answerFirst == inputFirst) strike++
		else if (answer.contains(inputFirst)) ball++
		// 두번째 자리 숫자 비교
		if (answerSecond == inputSecond) strike++
		else if (answer.contains(inputSecond)) ball++
		// 세번째 자리 숫자 비교
		if (answerThird == inputThird) strike++
		else if (answer.contains(inputThird)) ball++
		return mutableListOf<Int>(ball, strike)
	}
	// 결과 출력
	fun showResult(result:MutableList<Int>){
		var ball = result[0]
		var strike = result[1]
		if (ball + strike == 0) resultView.text = "아웃"
		else if (ball == 0){
			resultView.text = "${strike} 스트라이크"
			if (strike == 3) {
				Toast.makeText(this, "3개의 숫자를 모두 맞히셨습니다! 게임 종료", Toast.LENGTH_SHORT).show()
				resultView.text = "게임 재시작"
				gameRestart()
			}
		}
		else if (strike == 0) resultView.text = "${ball} 볼"
		else resultView.text = "${ball} 볼 ${strike} 스트라이크"
	}
	// 게임 재시작
	fun gameRestart(){
		answer = makeNumber()
		nowCount = 0
		input.setText("") //입력창 초기화
	}

}