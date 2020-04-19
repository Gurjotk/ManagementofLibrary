package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class home extends AppCompatActivity {
Spinner s1,s2;
EditText ed1, ed2;
Button i,r,p;
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
i.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(home.this,Book.class);
        startActivity(i);
    }
});
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
    }
}
