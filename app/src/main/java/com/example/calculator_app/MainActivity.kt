package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var model: ExpressionModel
    private lateinit var working: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ExpressionModel()
        working = findViewById(R.id.result_textview)
        working.text=model.getExpression()
    }

    fun onOperand(view: View?) {
        if (view is Button) {
            working.text = model.appendOperand(view.text as String)
        }
    }

    fun onOperator(view: View?) {
        if (view is Button) {
            working.text = model.appendOperator(view.text as String)
        }
    }

    fun onAllClear(view: View) {if (view is Button) {
        working.text = model.clearExpression()
    }}
    fun onResult(view: View) {
        if (view is Button) {
            var expression = model.getExpression()
            val result = if(expression.last().isDigit() || expression.last().equals(".")){
                ExpressionBuilder(expression).build()
            }
            else
            {
                expression = expression.dropLast(1)
                ExpressionBuilder(expression).build()
            }
            try {
                val answer  = result.evaluate()
                working.text =  answer.toString()
                model.setExpression(answer.toString())
            }
            catch (e: java.lang.ArithmeticException)
            {
                working.text=e.localizedMessage
                model.clearExpression()

            }
        }
    }
}


