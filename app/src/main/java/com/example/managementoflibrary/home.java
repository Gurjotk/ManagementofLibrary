package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class home extends AppCompatActivity {
Spinner s1,s2;
EditText ed1, ed2;
Button i,r,p;
    String language[]={"Language","English","Hindi","Punjabi","French"};
    String subject[]={"Fiction","Non-fiction","Religious","science","Political","comedy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
s1= findViewById(R.id.spinner);
s2= findViewById(R.id.spinner2);
ed1= findViewById(R.id.bname);
ed2= findViewById(R.id.aname);
i=findViewById(R.id.search);
r=findViewById(R.id.bookreturn);
p= findViewById(R.id.profile);
   r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,Return.class);
                startActivity(i);
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,register.class);
                startActivity(i);
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,Book.class);
                startActivity(i);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(home.this,
                android.R.layout.activity_list_item,language);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You choose: "+language[position],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(home.this,
                android.R.layout.activity_list_item,subject);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(getApplicationContext(),"You choose: "+subject[i],Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
