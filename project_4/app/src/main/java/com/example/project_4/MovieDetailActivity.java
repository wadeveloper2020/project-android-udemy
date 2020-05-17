package com.example.project_4;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.project_4.model.ResultsItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

public class MovieDetailActivity extends AppCompatActivity {

    ResultsItem dataMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//////////////////////////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getBundleExtra(MovieAdapter.DATA_EXTRA);        //
        dataMovie = Parcels.unwrap(bundle.getParcelable(MovieAdapter.DATA_MOVIE));  //
                                                                                    //
        getSupportActionBar().setTitle(dataMovie.getTitle());                       //
                                                                                    //
        ImageView ivbackdrop = findViewById(R.id.iv_detail_poster);                 //
        TextView tvoverview = findViewById(R.id.tv_description);                    //
                                                                                    //
        Glide.with(MovieDetailActivity.this)                                //
                .load("https://image.tmdb.org/t/p/w500"+dataMovie            //
                .getBackdropPath())                                                 //
                .into(ivbackdrop);                                                  //
        tvoverview.setText(dataMovie.getOverview());                                //
//////////////////////////////////////////////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
