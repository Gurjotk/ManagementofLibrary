package com.example.managementoflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class register extends AppCompatActivity {
EditText name,email,mobile,pass,repass;
Button reg;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;

   // private String BASE_URL = "http://192.168.2.20:3033";
    private Object HashMap;
    private Object String;

    /// commentline ipconfig run ipaddress
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        name = findViewById(R.id.reg_name);
        email = findViewById(R.id.reg_user_name);
        pass = findViewById(R.id.reg_password);
        repass = findViewById(R.id.reg_con_password);
        reg = findViewById(R.id.bn_reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final HashMap<String, String> map = new HashMap<>();
                map.put("name", name.getText().toString());
                map.put("email", email.getText().toString());
                map.put("password", repass.getText().toString());
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            try {

                                System.out.println("Call");
                        //        URL url = new URL("http://192.168.2.20:3033/register");
                                HttpURLConnection client = null;
                           //     client = (HttpURLConnection) url.openConnection();
                                client.setRequestMethod("POST");
                                client.setDoInput(true);
                                client.setDoOutput(true);

                                OutputStream os = client.getOutputStream();
                                BufferedWriter writer = new BufferedWriter(
                                        new OutputStreamWriter(os, "UTF-8"));

                                writer.flush();
                                writer.close();
                                os.close();
                                BufferedReader br;

                                if (100 <= client.getResponseCode() && client.getResponseCode() <= 200) {
                                    br = new BufferedReader(new InputStreamReader(client.getInputStream()));

                                } else {
                                    br = new BufferedReader(new InputStreamReader(client.getErrorStream()));

                                }
                                String content = br.readLine();

                                int responseCode = client.getResponseCode();
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("ERROR ******** " + e.getMessage());
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
            // Intent i = new Intent(register.this,home.class);
            // startActivity(i);
        });

    }
        private String getPostData(HashMap <String, String > map) throws UnsupportedEncodingException{

            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (first)
                    first = false;
                else
                    sb.append("&");

                try {
                    sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }

}

