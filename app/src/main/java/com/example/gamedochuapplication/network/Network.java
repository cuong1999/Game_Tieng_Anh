package com.example.gamedochuapplication.network;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Network {
    public interface Callback {
        public void onCallBack(String json);
        public void onFail(String error);
    }

    private static Network instance;
    private Network() {}

    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    OkHttpClient client = new OkHttpClient();
    public void executeGET(String link,String token,final Callback callback) {
        Request request = new Request.Builder()
                .url(link)
                .addHeader("Authorization","Bearer "+token)
                .build();

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                try {
                    String body = response.body().string();
                    callback.onCallBack(body);
                }
                catch(Exception e)
                {
                    e.getMessage();
                }
            }
        });
    }
    public void executePOST(String link,String json, final Callback callback) {

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(link)
                .post(body)
                .build();

        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                try {
                    String body = response.body().string();
                    callback.onCallBack(body);
                }
                catch(Exception e)
                {
                    e.getMessage();
                }
            }
        });
    }
}

