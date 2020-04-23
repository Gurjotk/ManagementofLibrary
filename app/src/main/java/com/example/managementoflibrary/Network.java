package com.example.managementoflibrary;

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

public class Network {
    public void Call(final HashMap<String, String> map, final String urlString) {
        String answer;
        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    try {

                        System.out.println("Calling ******** ");
                        URL url = new URL(urlString);
                        HttpURLConnection client = null;
                        client = (HttpURLConnection) url.openConnection();
                        client.setRequestMethod("POST");
                        client.setDoInput(true);
                        client.setDoOutput(true);

                        OutputStream os = client.getOutputStream();
                        BufferedWriter writer = new BufferedWriter(
                                new OutputStreamWriter(os, "UTF-8"));
                        writer.write(getPostDataString(map));

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


                        int rc = client.getResponseCode();

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("ERROR ******** " + e.getMessage());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private String getPostDataString(HashMap<String, String> map)  throws UnsupportedEncodingException {
                StringBuilder sb = new StringBuilder();
                boolean first = true;
                for(Map.Entry<String, String> entry : map.entrySet()){
                    if (first)
                        first = false;
                    else
                        sb.append("&");

                    sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                }

                return sb.toString();
            }


        });
        th.start();



    }
