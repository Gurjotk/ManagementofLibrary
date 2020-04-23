package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button login_button;
    Button b10;

    EditText UserName, Password;
    String username, password;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;

    private String BASE_URL = "http://192.168.2.20:3033";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        login_button = (Button) findViewById(R.id.bn_login);
        b10=(Button)findViewById(R.id.button10);

        UserName = (EditText) findViewById(R.id.login_name);
        Password = (EditText) findViewById(R.id.login_password);
        username = UserName.getText().toString();
        password = Password.getText().toString();
        Toast.makeText(MainActivity.this, username+password, Toast.LENGTH_SHORT).show();
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final HashMap<String, String> map = new HashMap<>();

                map.put("Username", UserName.getText().toString());
                map.put("password", Password.getText().toString());
                Intent i = new Intent(MainActivity.this, home.class);
                startActivity(i);
            }

        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, register.class);
                startActivity(i);
            }
        });
    }
}
