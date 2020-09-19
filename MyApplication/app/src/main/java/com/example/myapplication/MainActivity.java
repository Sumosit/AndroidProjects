package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView calories;
    SeekBar seekBar_sauceValue;
    ImageView burger;
    int a = 0, b = 0, c = 0, d = 0;
    // Calories = a + b + c + d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calories = (TextView) findViewById(R.id.textView_Calories);
        seekBar_sauceValue = (SeekBar) findViewById(R.id.seekBar_sauceValue);
        burger = (ImageView) findViewById(R.id.imageView_burgerProgressDark);
        burger.setAlpha((float)0);

        seekBar_sauceValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                d =  seekBar.getProgress();
                calories.setText("Calories: " + String.valueOf(a + b + c + d));
                burger.setAlpha((float)d / 100);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBox_Prosciutto:
                if (checked) {
                    b = 100;
                } else {
                    b = 0;
                }
        }
        calories.setText("Calories: " + String.valueOf(a + b + c + d));
    }

    @SuppressLint("SetTextI18n")
    public void OnRadioButtonClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton_Beef:
                if (checked)
                    a = 250;
                break;
            case R.id.radioButton_Ostrich:
                if (checked)
                    a = 260;
                break;
            case R.id.radioButton_Lamb:
                if (checked)
                    a = 240;
                break;
            case R.id.radioButton_Asiago:
                if (checked)
                    c = 50;
                break;
            case R.id.radioButton_Creme:
                if (checked)
                    c = 60;
                break;
        }
        calories.setText("Calories: " + String.valueOf(a + b + c + d));
    }
}