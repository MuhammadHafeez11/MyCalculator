package com.example.mycalculator;

import static com.example.mycalculator.R.id.Add;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Defining the Views
    EditText Num1;
    EditText Num2;
    Button Add;
    Button Sub;
    Button Mul;
    Button Div;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referring the Views
        Num1 = findViewById(R.id.editText1);
        Num2 = findViewById(R.id.editText2);
        Add = findViewById(R.id.Add);
        Sub = findViewById(R.id.Sub);
        Mul = findViewById(R.id.Mul);
        Div = findViewById(R.id.Div);
        Result = findViewById(R.id.textView);

        // set a listener
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        float num1;
        float num2;
        float result;
        String oper = "";

        // check if the fields are empty
        if (TextUtils.isEmpty(Num1.getText().toString()) || TextUtils.isEmpty(Num2.getText().toString()))
            return;

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(Num1.getText().toString());
        num2 = Float.parseFloat(Num2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into operator, we will use it later for output
        if (v.getId() == R.id.Add) {
            oper = "+";
            result = num1 + num2;
        } else if (v.getId() == R.id.Sub) {
            oper = "-";
            result = num1 - num2;
        } else if (v.getId() == R.id.Mul) {
            oper = "*";
            result = num1 * num2;
        } else if (v.getId() == R.id.Div) {
            oper = "/";
            result = num1 / num2;
        } else {
            result = 0;
        }

        // form the output line
        Result.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}