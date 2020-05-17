package com.example.project_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project_4.model.ResponseMovie;
import com.example.project_4.model.ResultsItem;
import com.example.project_4.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<ResultsItem> dataMovie = new ArrayList<>();
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler = findViewById(R.id.recyclerView);
        //1.layout per item
        //2. model data
        //dammy data
//        ModelMovie movie1 = new ModelMovie();
//        movie1.setJudulFilm("Judul Film");
//        movie1.setPosterFilm("https://image.tmdb.org/t/p/w600_and_h900_bestv2/iZf0KyrE25z1sage4SYFLCCrMi9.jpg");
//
//        for (int i = 0; i <20; i++) {
//            dataMovie.add(movie1);
//        }
        //3. adapter

            getOnlineData();

            recycler.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
        //4. layout manager
            recycler.setLayoutManager(new GridLayoutManager(MainActivity.this,2));


    }

    private void getOnlineData() {
        Call<ResponseMovie> request = RetrofitConfig.getApiService().ambilDataMovie("b416b960b7f3aae9611778a5814f13eb");
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful()){
                    dataMovie = response.body().getResults();
                    recycler.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
                }else {
                    Toast.makeText(MainActivity.this, "Request Not Succes..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Request Failure.." + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
