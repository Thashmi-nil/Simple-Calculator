package lk.ucsc.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textNumber1, textNumber2 ;
    TextView resultSum, resultSub;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumber1 = findViewById(R.id.textNumber1);
        textNumber2 = findViewById(R.id.textNumber2);

        Button buttonSum = findViewById(R.id.sumButton);
        Button buttonSub = findViewById(R.id.subButton);

        // click listener for buttonSum
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    goToSumPage();
                }
            }
        });

        // click listener for buttonSub
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSubPage();
            }
        });
    }

    private boolean CheckAllFields() {

        // check for empty fields
        if (textNumber1.length() == 0) {
            textNumber1.setError("This field is required");
            return false;
        }
        if (textNumber2.length() == 0) {
            textNumber2.setError("This field is required");
            return false;
        }
        return true;
    }

    public void goToSumPage(){
        Intent intent = new Intent(this, sum.class);

        // send data to calculate summation
        intent.putExtra("num1",textNumber1.getText().toString());
        intent.putExtra("num2",textNumber2.getText().toString());

        // start activity
        startActivity(intent);
    }

    public void goToSubPage(){
        Intent intent = new Intent(this, sub.class);

        // send data to calculate subtraction
        intent.putExtra("num1",textNumber1.getText().toString());
        intent.putExtra("num2",textNumber2.getText().toString());

        // start activity
        startActivity(intent);
    }
}