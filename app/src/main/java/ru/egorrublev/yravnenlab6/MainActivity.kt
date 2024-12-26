package ru.egorrublev.yravnenlab6

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var textViewResult: TextView
    private lateinit var buttonSolve: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        editTextA = findViewById(R.id.editText1) // Поле для a
        editTextB = findViewById(R.id.editText2) // Поле для b
        editTextC = findViewById(R.id.editText3) // Поле для c
        textViewResult = findViewById(R.id.textView9) // Поле для вывода результата
        buttonSolve = findViewById(R.id.button) // Кнопка для решения уравнения

        // Установка обработчика нажатия на кнопку
        buttonSolve.setOnClickListener {
            solveQuadraticEquation()
        }
    }

    private fun solveQuadraticEquation() {
        // Получаем значения a, b и c из EditText
        val a = editTextA.text.toString().toDoubleOrNull()
        val b = editTextB.text.toString().toDoubleOrNull()
        val c = editTextC.text.toString().toDoubleOrNull()

        // Проверяем, что все значения введены корректно
        if (a == null || b == null || c == null) {
            textViewResult.text = "Пожалуйста, введите корректные значения для a, b и c."
            return
        }

        // Вычисляем дискриминант
        val discriminant = b * b - 4 * a * c

        // Проверяем дискриминант и находим корни
        when {
            discriminant > 0 -> {
                val root1 = (-b + sqrt(discriminant)) / (2 * a)
                val root2 = (-b - sqrt(discriminant)) / (2 * a)
                textViewResult.text = "Найдено два корня: $root1 и $root2"
            }
            discriminant == 0.0 -> {
                val root = -b / (2 * a)
                textViewResult.text = "Найден один корень: $root"
            }
            else -> {
                textViewResult.text = "Корней нет."
            }
        }
    }
}