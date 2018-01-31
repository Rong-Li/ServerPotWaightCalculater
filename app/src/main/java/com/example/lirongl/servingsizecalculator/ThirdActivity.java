package com.example.lirongl.servingsizecalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private String theName;
    private int theWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ExtractData();
        setThePot();
        exitTheActivity();
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
