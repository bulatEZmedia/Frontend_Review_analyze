package com.example.review_analyze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextrequest = findViewById(R.id.editTextMessage);
        String request = editTextrequest.getText().toString().trim();
        Button begin = findViewById(R.id.then);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://18.199.92.36:3000")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        api = retrofit.create(Api.class);


        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ChoiceAnalyzeActivity.class);
                startActivity(intent);




                Call<ResponseBody> call = api.sendMessage(new RequestBody(request));
                call.enqueue((new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("request ok", String.valueOf(response.code()));

                            String benefit = response.body().string();
                            String solution = response.body().string();
                            String deficit = response.body().string();
                            intent.putExtra("fname", benefit);
                            intent.putExtra("lname", solution);




                        }
                        catch (Exception e){
                            Log.e("request error", e.getMessage());
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                }));


            }
        });






    }
}