package com.example.AnotherQuizApp.ui.learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.AnotherQuizApp.LoginActivity;
import com.example.AnotherQuizApp.R;
import com.example.AnotherQuizApp.ui.adapter.LearnCustomAdapter;
import com.example.AnotherQuizApp.ui.adapter.ChapterData;
import com.example.AnotherQuizApp.ui.home.HomeActivity;
import com.example.AnotherQuizApp.ui.profile.ProfileActivity;
import com.example.AnotherQuizApp.ui.quizzes.QuizzesActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.List;

public class LearnCPlusPlusActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String,List<String>> expandableListDetail;
    /*String chapterOne = getString(R.string.chapter_one_title), chapterTwo = getString(R.string.chapter_two_title),
            chapterThree = getString(R.string.chapter_three_title), chapterFour = getString(R.string.chapter_four_title),
            chapterFive = getString(R.string.chapter_five_title), chapterSix = getString(R.string.chapter_six_title),
            chapterSeven = getString(R.string.chapter_seven_title), chapterOneContents = getString(R.string.chapter_one_contents),
            chapterTwoContents = getString(R.string.chapter_two_contents), chapterThreeContents = getString(R.string.chapter_three_contents),
            chapterFourContents = getString(R.string.chapter_four_contents), chapterFiveContents = getString(R.string.chapter_five_contents),
            chapterSixContents = getString(R.string.chapter_six_contents), chapterSevenContents = getString(R.string.chapter_seven_contents);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_c_plus_plus);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChapterData[] chapterData = new ChapterData[]{
                new ChapterData("Introduction","Instructions for Use",R.drawable.cplusplus_chapter_one),
                new ChapterData("Basics of C++","Structures, Data Types, and Input, Output",R.drawable.cplusplus_chapter_two),
                new ChapterData("Control Structures","Control Structures and Functions",R.drawable.cplusplus_chapter_three),
                new ChapterData("Compound Data Types","Arrays, Pointers, Memory, and Other Data Types",R.drawable.cplusplus_chapter_four),
                new ChapterData("Object Oriented Programming","Classes, Friends, and Polymorphism",R.drawable.cplusplus_chapter_five),
                new ChapterData("Advanced Concepts","Templates, Namespaces, and Type Casting",R.drawable.cplusplus_chapter_six),
                new ChapterData("C++ Standard Library","File Input and Output",R.drawable.cplusplus_chapter_seven),
        };

        LearnCustomAdapter learnCustomAdapter = new LearnCustomAdapter(chapterData,LearnCPlusPlusActivity.this);
        recyclerView.setAdapter(learnCustomAdapter);

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
