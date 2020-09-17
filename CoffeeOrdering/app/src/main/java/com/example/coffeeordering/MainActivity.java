package com.example.coffeeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView priceList, quantity;
    boolean chocolate = false, cream = false, order = false;
    int quantityCount = 0;
    double price = 0.0, factor = 0.0;
    Button buttonMinus, buttonPlus;
    String outputGoods = "", outputPrice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        priceList = (TextView) findViewById(R.id.TextView_PriceList);
        quantity = (TextView) findViewById(R.id.TextViewQuantity);

        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);

        priceList.setText(outputGoods);
    }

    @SuppressLint("SetTextI18n")
    public void onCheckBoxClicked(View view) {
        outputGoods = "";
        outputPrice = "";
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox_Chocolate:
                if (checked) {
                    factor = factor + 2.25;
                    chocolate = true;
                } else {
                    factor = factor - 2.25;
                    chocolate = false;
                }
                break;
            case R.id.checkBox_Cream:
                if (checked) {
                    factor = factor + 2.25;
                    cream = true;
                } else {
                    factor = factor - 2.25;
                    cream = false;
                }
                break;
        }
        System.out.println(price);
        price = factor * quantityCount;
        if (chocolate && cream) {
            outputGoods = "Chocolate\nCream";
        }
        else if (chocolate) {
            outputGoods = "Chocolate";
        }
        else if (cream) {
            outputGoods = "Cream";
        }
        else {
            outputGoods = "";
        }
        outputPrice = outputPrice + "\nQuantity: "
                + quantityCount + "\n\nPrice: " + price;
        if (order && quantityCount >= 1 && (cream || chocolate)) {
            outputPrice = outputPrice + "\nTHANK YOU!";
        }
        else {
            outputPrice = outputPrice.replaceAll("\nTHANK YOU!", "");
        }
        priceList.setText(outputGoods + outputPrice);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        outputPrice = "";
        switch (view.getId()) {
            case R.id.buttonMinus:
                if (quantityCount > 0) {
                    quantityCount--;
                    quantity.setText(Integer.toString(quantityCount));
                    price = price - factor;
                }
                break;
            case R.id.buttonPlus:
                if (quantityCount < 10) {
                    quantityCount++;
                    quantity.setText(Integer.toString(quantityCount));
                    price = price +factor;
                }
                break;
            case R.id.buttonOrder:
                order = !order;
        }

        outputPrice = outputPrice + "\nQuantity: "
                + quantityCount + "\n\nPrice: " + price;
        if (order && quantityCount >= 1 && (cream || chocolate)) {
            outputPrice = outputPrice + "\nTHANK YOU!";
        }
        else {
            order = false;
            outputPrice = outputPrice.replaceAll("\nTHANK YOU!", "");
        }
        priceList.setText(outputGoods + outputPrice);
    }
}