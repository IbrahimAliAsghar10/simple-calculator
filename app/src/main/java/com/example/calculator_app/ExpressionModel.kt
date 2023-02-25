package com.example.calculator_app

class ExpressionModel {
    private var decimalFlag:Boolean = false
    private var operatorFlag:Boolean = false
    private var expression:String = "0"
    fun appendOperator(character:String):String
    {
        return if (decimalFlag || operatorFlag) {
            if (operatorFlag)
            {
                expression
            }
            else{
                operatorFlag = true
                decimalFlag = false
                expression = expression + '0' + character
                expression
            }


        } else {
            operatorFlag = true
            decimalFlag = false
            expression += character
            expression
        }
    }

    fun appendOperand(character:String):String
    {
        return if(character == "."){

            if (decimalFlag) {
                operatorFlag = false
                decimalFlag = true
                expression
            } else if (operatorFlag){
                operatorFlag = false
                decimalFlag = true
                expression = expression + '0'+ character
                expression
            }
            else
            {
                operatorFlag = false
                decimalFlag = true
                expression+=character
                expression
            }

        }
        else{
            operatorFlag = false
            if (expression == "0")
            {
                expression = character
                expression
            }
            else{
                expression+=character
                expression
            }
        }
    }
    fun getExpression(): String {
        return expression
    }
    fun setExpression(result:String)
    {
        expression = result
        operatorFlag = false
    }
    fun  clearExpression():String
    {
        decimalFlag = false
        operatorFlag = false
        expression = "0"
        return expression
    }





}