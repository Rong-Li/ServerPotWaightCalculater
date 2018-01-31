package com.example.lirongl.servingsizecalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setupActivityButton();
    }

    private void setupActivityButton() {
        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Extract entered Name
                EditText first_entered = (EditText) findViewById(R.id.insertNameID);
                String newName = first_entered.getText().toString();
                //Extract entered Weight
                EditText second_entered = (EditText) findViewById(R.id.insertWeightID);
                String newWeight_instring = second_entered.getText().toString();
                int newWeight = Integer.parseInt(newWeight_instring);
                //make a new pot
                //Pot newPot = new Pot(newName, newWeight);

                //pass data to intent
                Intent theIntent = new Intent();
                theIntent.putExtra("theNewPotName", newName);
                theIntent.putExtra("theNewPotWeight", newWeight);
                setResult(Activity.RESULT_OK, theIntent);
                finish();
            }
        });
    }

    public static  Intent newIntent(Context context)
    {
        return new Intent(context, SecondActivity.class);
    }
}
