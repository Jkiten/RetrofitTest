package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit =  new ApiClient().getClient();
    RetrofitService service = retrofit.create(RetrofitService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("start","start");
        Call<JsonArray> call = service.getUsers();
        Log.d("선언","선언");
        try {
            call.enqueue(
                    new Callback<JsonArray>() {
                        @Override
                        public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                            JsonArray jsonArray =response.body();

                            Log.d("실행성공", jsonArray.toString());



                        }

                        @Override
                        public void onFailure(Call<JsonArray> call, Throwable t) {
                            Log.d("실행error",t.toString());

                        }
                    }
            );


            Log.d("실행","실행");
//            if(response.isSuccessful()){
//                Log.d("성공",response.body().toString());
//            }else{
//                Log.d("실패","실패");
//            }
        }
        catch (Exception e){
            Log.d("error",e.toString());

        }
    }
}