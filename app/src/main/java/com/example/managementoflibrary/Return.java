package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Return extends AppCompatActivity {
EditText num;
Button ret, iagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        num=  findViewById(R.id.number);
        ret= findViewById(R.id.returnb);
        iagain= findViewById(R.id.issueagain);
        iagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Return.this,home.class);
                startActivity(i);
            }
        });
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Return.this,home.class);
                startActivity(i);
            }
        });

    }
}
