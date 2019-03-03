package com.siddhantbhatia.calcoolator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculatorScreen extends AppCompatActivity implements View.OnClickListener{

    String outputString = "";
    String userInputString = "";

    double firstNumber = 0;
    double secondNumber = 0;
    double result = 0;

    int operationType = 0;

    boolean decimalPressed = false;
    boolean equalPressed = false;

    TextView resultDisplay;
    TextView userInputDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_screen);

        resultDisplay = findViewById(R.id.resultDisplay);
        userInputDisplay = findViewById(R.id.userInputDisplay);

        Button zero = findViewById(R.id.number0);
        zero.setOnClickListener(this);

        Button one = findViewById(R.id.number1);
        one.setOnClickListener(this);

        Button two = findViewById(R.id.number2);
        two.setOnClickListener(this);

        Button three = findViewById(R.id.number3);
        three.setOnClickListener(this);

        Button four = findViewById(R.id.number4);
        four.setOnClickListener(this);

        Button five = findViewById(R.id.number5);
        five.setOnClickListener(this);

        Button six = findViewById(R.id.number6);
        six.setOnClickListener(this);

        Button seven = findViewById(R.id.number7);
        seven.setOnClickListener(this);

        Button eight = findViewById(R.id.number8);
        eight.setOnClickListener(this);

        Button nine = findViewById(R.id.number9);
        nine.setOnClickListener(this);

        Button plus = findViewById(R.id.operationPlus);
        plus.setOnClickListener(this);

        Button minus = findViewById(R.id.operationMinus);
        minus.setOnClickListener(this);

        Button multiply = findViewById(R.id.operationMultiply);
        multiply.setOnClickListener(this);

        Button divide = findViewById(R.id.operationDivide);
        divide.setOnClickListener(this);

        Button decimal = findViewById(R.id.operationDecimal);
        decimal.setOnClickListener(this);

        Button equal = findViewById(R.id.operationEqual);
        equal.setOnClickListener(this);

        Button clear = findViewById(R.id.operationClear);
        clear.setOnClickListener(this);
    }

    public void setDisplay(String output, String userInput){
        outputString += output;
        userInputString += userInput;

        resultDisplay.setText(outputString);
        userInputDisplay.setText(userInputString);
    }

    @Override
    public void onClick(View v){

        if (equalPressed){
            outputString = "";
            userInputString = "";

            setDisplay("","");

            equalPressed = false;
        }
        switch(v.getId()) {

            //getting the number input
            case R.id.number0:
                setDisplay("0", "0");
                break;

            case R.id.number1:
                setDisplay("1", "1");
                break;

            case R.id.number2:
                setDisplay("2", "2");
                break;

            case R.id.number3:
                setDisplay("3", "3");
                break;

            case R.id.number4:
                setDisplay("4", "4");
                break;

            case R.id.number5:
                setDisplay("5", "5");
                break;

            case R.id.number6:
                setDisplay("6", "6");
                break;

            case R.id.number7:
                setDisplay("7", "7");
                break;

            case R.id.number8:
                setDisplay("8", "8");
                break;

            case R.id.number9:
                setDisplay("9", "9");
                break;

            //getting the type of operation to be done
            case R.id.operationPlus:
                firstNumber = Double.parseDouble(outputString);
                Log.d("myTag: firstNumber:", Double.toString(firstNumber));
                outputString = "";
                setDisplay("", "+");
                operationType = 1;

                decimalPressed = false;
                break;

            case R.id.operationMinus:
                firstNumber = Double.parseDouble(outputString);
                outputString = "";
                setDisplay("", "-");
                operationType = 2;

                decimalPressed = false;
                break;

            case R.id.operationMultiply:
                firstNumber = Double.parseDouble(outputString);
                outputString = "";
                setDisplay("", "x");
                operationType = 3;

                decimalPressed = false;
                break;

            case R.id.operationDivide:
                firstNumber = Double.parseDouble(outputString);
                outputString = "";
                setDisplay("", "/");
                operationType = 4;

                decimalPressed = false;
                break;

            case R.id.operationDecimal:
                if (!decimalPressed) {

                    Log.d("myTag: check decimal:", "yes");
                    setDisplay(".", ".");

                    decimalPressed = true;
                }
                break;

            case R.id.operationEqual:
                if (operationType == 0) {
                    setDisplay("", "");
                } else {
                    secondNumber = Double.parseDouble(outputString);
                    Log.d("myTag: secondNumber:", Double.toString(secondNumber));
                    switch (operationType) {
                        case 1:
                            result = firstNumber + secondNumber;
                            break;

                        case 2:
                            result = firstNumber - secondNumber;
                            break;

                        case 3:
                            result = firstNumber * secondNumber;
                            break;

                        case 4:
                            result = firstNumber / secondNumber;
                            break;

                        default:
                            break;
                    }

                    outputString = Double.toString(result);
                    //Log.d("myTag: result:", outputString);
                    setDisplay("", "");
                    userInputString = "";
                    outputString = "";

                    equalPressed = true;
                    decimalPressed = false;
                }
                break;

            case R.id.operationClear:
                outputString = "";
                userInputString = "";
                setDisplay(outputString, userInputString);

                decimalPressed = false;
                break;

            default:
                break;
        }
    }
}
