package lk.ucsc.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sub extends AppCompatActivity {

    int number1, number2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView sumResult = findViewById(R.id.subResult);
        TextView num1 = findViewById(R.id.subNum1);
        TextView num2 = findViewById(R.id.subNum2);

        Button backButton = findViewById(R.id.backButton2);

        // turn 2 numbers in to int values
        number1 = Integer.valueOf(getIntent().getStringExtra("num1"));
        number2 = Integer.valueOf(getIntent().getStringExtra("num2"));

        result = number1 - number2;

        num1.setText(String.valueOf(number1));
        num2.setText(String.valueOf(number2));
        sumResult.setText(String.valueOf(result));
        sumResult.setTextColor(Color.parseColor("#800000"));

        // click listener for backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // go back to MainActivity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}