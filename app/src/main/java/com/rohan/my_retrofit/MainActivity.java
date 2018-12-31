package com.rohan.my_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rohan.my_retrofit.pojo.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<Login> call = api.getMyJSON("aniruddh.rathod24@gmail.com", "user@1234");

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                String status = "not initialized";

                if (response.isSuccessful()) {
                    status = response.body().getMessage().toString();
                }
                Toast.makeText(getApplicationContext(), status, Toast.LENGTH_LONG).show();

            }


            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }


        });
       // Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show();
    }

}
