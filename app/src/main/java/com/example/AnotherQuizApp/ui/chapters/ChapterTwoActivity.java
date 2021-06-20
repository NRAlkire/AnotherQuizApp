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

public class ChapterTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two);


        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("c_plus_plus_tutorial.pdf").pages(6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,
                26,27,28,29,30,31,32).swipeHorizontal(true).load();

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