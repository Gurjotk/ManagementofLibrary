package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Book extends AppCompatActivity {
TextView bname, author,desc;
Button i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
bname=findViewById(R.id.btitle);
author=findViewById(R.id.abname);
desc = findViewById(R.id.description);
i=findViewById(R.id.issue);
i.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(Book.this,MainActivity.class);
        startActivity(i);
    }
});



    }
}
