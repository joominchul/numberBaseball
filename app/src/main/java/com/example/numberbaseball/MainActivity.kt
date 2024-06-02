package com.example.numberbaseball

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
	//숫자 범위
	private val RANGE = (1..9)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

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
}