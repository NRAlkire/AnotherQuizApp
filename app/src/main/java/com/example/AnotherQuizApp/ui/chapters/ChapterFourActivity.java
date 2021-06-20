package com.example.AnotherQuizApp.ui.chapters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.AnotherQuizApp.LoginActivity;
import com.example.AnotherQuizApp.R;
import com.example.AnotherQuizApp.ui.home.HomeActivity;
import com.example.AnotherQuizApp.ui.learn.LearnCPlusPlusActivity;
import com.example.AnotherQuizApp.ui.profile.ProfileActivity;
import com.example.AnotherQuizApp.ui.quizzes.QuizzesActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import android.view.MenuItem;

public class ChapterFourActivity extends AppCompatActivity {


    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_four);

        pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("c_plus_plus_tutorial.pdf").pages(53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,
                71,72,73,74,75,76,77,78,79,80,81,82,83,84).swipeHorizontal(true).load();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.learn);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.learn:
                        startActivity(new Intent(getApplicationContext(), LearnCPlusPlusActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.quizzes:
                        startActivity(new Intent(getApplicationContext(), QuizzesActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();//logout
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                }
                return false;
            }
        });

    }
}