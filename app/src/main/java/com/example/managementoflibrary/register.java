package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {
EditText name,email,mobile,pass,repass;
Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name =findViewById(R.id.reg_name);
        email=findViewById(R.id.reg_user_name);
        mobile=findViewById(R.id.reg_mob);
        pass =findViewById(R.id.reg_password);
        repass =findViewById(R.id.reg_con_password);
        reg =findViewById(R.id.bn_reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
