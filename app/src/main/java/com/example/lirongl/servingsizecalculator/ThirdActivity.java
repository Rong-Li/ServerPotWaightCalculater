package com.example.lirongl.servingsizecalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private String theName;
    private int theWeight;
    private int totalWeight;
    private int foodWeight;
    private int servingNumber = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ExtractData();
        setThePot();
        exitTheActivity();
        computeTheResult();
    }


    private void ExtractData() {
        Intent intent = getIntent();
        theName = intent.getStringExtra("PotsName");
        theWeight = intent.getIntExtra("PotsWeight", 1);
    }

    private void setThePot() {
        TextView firstText = (TextView) findViewById(R.id.potpotID);
        firstText.setText(theName);
        TextView secondText = (TextView) findViewById(R.id.weightwieghtID);
        secondText.setText("" + theWeight);
    }

    private void computeTheResult() {
        final EditText inputOne = (EditText) findViewById(R.id.withFood);
        final EditText inputTwo = (EditText) findViewById(R.id.servingNumbers);

        inputOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String weightInString = inputOne.getText().toString();
                totalWeight = Integer.parseInt(weightInString);
                foodWeight = totalWeight - theWeight;
                TextView textview = (TextView) findViewById(R.id.foodWeightID);
                textview.setText(""+foodWeight);
            }
        });

        inputTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String servingInString = inputTwo.getText().toString();
                servingNumber = Integer.parseInt(servingInString);
                if (servingNumber > 0)
                {int finalWeightinInteger = foodWeight / servingNumber;
                TextView finalWeight = (TextView) findViewById(R.id.finalID);
                finalWeight.setText("" + finalWeightinInteger);
                }
            }
        });


    }

    private void exitTheActivity() {
        Button btn = (Button) findViewById(R.id.backBtnID);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static Intent newIntent(Context context, String PotsName, int PotsWeight){
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra("PotsName", PotsName);
        intent.putExtra("PotsWeight", PotsWeight);
        return intent;
    }
}
