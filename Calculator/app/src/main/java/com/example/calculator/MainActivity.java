package com.example.calculator;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    String number = "", operator = "";
    int number1, number2;
    int[] numbers = new int[10];

    EditText total;
    Button button_0, button_1, button_2, button_3, button_4, button_5,
            button_6, button_7, button_8, button_9, button_percent, button_divide,
            button_multiple, button_minus, button_plus, button_getTotal, button_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.editText_total);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_percent = findViewById(R.id.button_percent);
        button_divide = findViewById(R.id.button_divide);
        button_multiple = findViewById(R.id.button_multiple);
        button_minus = findViewById(R.id.button_minus);
        button_plus = findViewById(R.id.button_plus);
        button_getTotal = findViewById(R.id.button_getTotal);
        button_ac = findViewById(R.id.button_ac);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 1;
                total.setText(total.getText() + "1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 2;
                total.setText(total.getText() + "2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 3;
                total.setText(total.getText() + "3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 4;
                total.setText(total.getText() + "4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 5;
                total.setText(total.getText() + "5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 6;
                total.setText(total.getText() + "6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 7;
                total.setText(total.getText() + "7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 8;
                total.setText(total.getText() + "8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 9;
                total.setText(total.getText() + "9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 0;
                total.setText(total.getText() + "0");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = number + 0;
                total.setText(total.getText() + "0");
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(total.getText() + " - ");
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(total.getText() + " + ");
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(total.getText() + " / ");
            }
        });

        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(total.getText() + " * ");
            }
        });

        button_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(total.getText() + " % ");
            }
        });

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText("");
            }
        });

        button_getTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> nums = new ArrayList<>();
                String operations;
                int sum;
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(total.getText().toString());
                while (m.find()) {
                    nums.add(Integer.valueOf(m.group()));
                }
                operations = total.getText().toString().replaceAll("\\d", "").replaceAll(" ", "");
                if (operations.length() > nums.size()) {
                    total.setText("Wrong equation");
                    return;
                }
                sum = nums.get(0);
                for (int i = 1; i < nums.size(); i++) {
                    if (operations.charAt(i - 1) == '+') {
                        sum = sum + nums.get(i);
                    } else if (operations.charAt(i - 1) == '-') {
                        sum = sum - nums.get(i);
                    } else if (operations.charAt(i - 1) == '*') {
                        sum = sum * nums.get(i);
                    } else if (operations.charAt(i - 1) == '/') {
                        sum = sum / nums.get(i);
                    } else if (operations.charAt(i - 1) == '%') {
                        sum = sum % nums.get(i);
                    }
                }
                total.setText(total.getText().toString() + "= " + sum);
            }
        });
    }
}