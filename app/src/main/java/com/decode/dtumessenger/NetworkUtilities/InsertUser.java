package com.decode.dtumessenger.NetworkUtilities;

import android.content.Context;
import android.util.Log;

import com.decode.dtumessenger.Models.Message;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Aditya on 2/26/2017.
 */

public class InsertUser {

    String resp = "error";
    // function get json from url
    // by making HTTP POST or GET mehtod
    public String makeHttpRequest(String name,String id, String contact, String status) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("user_id", id)
                .add("name", name)
                .add("contact", contact)
                .add("status", status)
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.137.1/registerUser.php")
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            Log.d("send",request.toString());
            if(response.isSuccessful()){
                Log.d("send","success");
                return "S";
            }

            // Do something with the response.
        } catch (IOException e) {
            Log.d("send",e.toString());
            e.printStackTrace();
        }

        return "F";
    }

}
