package com.example.lirongl.servingsizecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_CODE_acceptIntent = 666;
    public PotCollection theCollection = new PotCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PopulateList();
        RegisterClickCallBack();
        SetButton();
    }


    private void SetButton() {
        Button btn = (Button) findViewById(R.id.addPot);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launching second activity
                Intent intent = SecondActivity.newIntent(MainActivity.this);
                startActivityForResult(intent, REQUEST_CODE_acceptIntent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case REQUEST_CODE_acceptIntent:
                if(resultCode == Activity.RESULT_OK){
                    String a = data.getStringExtra("theNewPotName");
                    int b = data.getIntExtra("theNewPotWeight", 1);
                    Pot addonPot = new Pot(a,b);
                    theCollection.addPot(addonPot);
                    String[] runIt = theCollection.getPotDescriptions();
                    String theMessage = "Successfully added"+runIt[0];
                    Log.i("MyApp", theMessage);

                    //Show the new list
                    PopulateList();
                } else{
                    PopulateList();
                    Log.i("MyApp", "Nothing is been added");
                }

        }
    }


    private void PopulateList() {
        //create list of items
//        Pot a = new Pot("bigbigpot", 26);
//        PotCollection theCollection = new PotCollection();
//        theCollection.addPot(a);

        String[] myItems = theCollection.getPotDescriptions();

        //Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.pots_item, myItems);

        //Configure the list view
        ListView list = (ListView) findViewById(R.id.listViewID);
        list.setAdapter(adapter);
    }

    private void RegisterClickCallBack() {
        ListView list = (ListView) findViewById(R.id.listViewID);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View viewClicked, int position, long id) {
                TextView textview = (TextView) viewClicked;
                String message = "you clicked #" + position + ", which is string: "+ textview.getText();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                Pot temp = theCollection.getPot(position);
                String a = temp.getName();
                int b = temp.getWeightInG();
                Intent intent = ThirdActivity.newIntent(MainActivity.this, a, b);
                startActivity(intent);
            }
        });
    }

}
