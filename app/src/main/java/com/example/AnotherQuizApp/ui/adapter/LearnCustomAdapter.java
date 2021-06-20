package com.example.AnotherQuizApp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.AnotherQuizApp.R;
import com.example.AnotherQuizApp.ui.chapters.ChapterFiveActivity;
import com.example.AnotherQuizApp.ui.chapters.ChapterFourActivity;
import com.example.AnotherQuizApp.ui.chapters.ChapterOneActivity;
import com.example.AnotherQuizApp.ui.chapters.ChapterSevenActivity;
import com.example.AnotherQuizApp.ui.chapters.ChapterSixActivity;
import com.example.AnotherQuizApp.ui.chapters.ChapterThreeActivity;
import com.example.AnotherQuizApp.ui.chapters.ChapterTwoActivity;
import com.example.AnotherQuizApp.ui.home.HomeActivity;
import com.example.AnotherQuizApp.ui.learn.LearnCPlusPlusActivity;
import com.example.AnotherQuizApp.ui.quizzes.QuizzesActivity;

public class LearnCustomAdapter extends RecyclerView.Adapter<LearnCustomAdapter.ViewHolder> {

    ChapterData[] chapterData;
    Context context;

    public LearnCustomAdapter(ChapterData[] chapterData, LearnCPlusPlusActivity activity) {
        this.chapterData = chapterData;
        this.context = activity;
    }
    public LearnCustomAdapter(ChapterData[] chapterData, QuizzesActivity activity) {
        this.chapterData = chapterData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chapter_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /*@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ChapterData chapterDataList = chapterData[position];
        holder.chapterTitle.setText(chapterDataList.getChapterName());
        holder.chapterContents.setText(chapterDataList.getChapterContents());
        holder.chapterImage.setImageResource(chapterDataList.getChapterImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, chapterDataList.getChapterName(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ChapterData chapterDataList = chapterData[position];
        holder.chapterTitle.setText(chapterDataList.getChapterName());
        holder.chapterContents.setText(chapterDataList.getChapterContents());
        holder.chapterImage.setImageResource(chapterDataList.getChapterImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (holder.getAdapterPosition()) {
                    case 0:
                        Intent chapter_one_intent = new Intent (context, ChapterOneActivity.class);
                        context.startActivity(chapter_one_intent);
                        //context.startActivity(new Intent(context.getApplicationContext(), ChapterOneActivity.class));
                        break;
                    case 1:
                        Intent chapter_two_intent = new Intent (context, ChapterTwoActivity.class);
                        context.startActivity(chapter_two_intent);
                        //context.startActivity(new Intent(context.getApplicationContext(), ChapterTwoActivity.class));
                        break;
                    case 2:
                        Intent chapter_three_intent = new Intent (context, ChapterThreeActivity.class);
                        context.startActivity(chapter_three_intent);
                        break;
                        //context.startActivity(new Intent(context.getApplicationContext(), HomeActivity.class));

                    case 3:
                        Intent chapter_four_intent = new Intent (context, ChapterFourActivity.class);
                        context.startActivity(chapter_four_intent);
                        break;
                        //context.startActivity(new Intent(context.getApplicationContext(), HomeActivity.class));

                    case 4:
                        Intent chapter_five_intent = new Intent (context, ChapterFiveActivity.class);
                        context.startActivity(chapter_five_intent);
                        break;
                        //context.startActivity(new Intent(context.getApplicationContext(), HomeActivity.class));

                    case 5:
                        Intent chapter_six_intent = new Intent (context, ChapterSixActivity.class);
                        context.startActivity(chapter_six_intent);
                        break;
                        //context.startActivity(new Intent(context.getApplicationContext(), HomeActivity.class));

                    case 6:
                        Intent chapter_seven_intent = new Intent (context, ChapterSevenActivity.class);
                        context.startActivity(chapter_seven_intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterData.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView chapterImage;
        TextView chapterTitle;
        TextView chapterContents;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterImage = itemView.findViewById(R.id.imageview);
            chapterTitle = itemView.findViewById(R.id.textName);
            chapterContents = itemView.findViewById(R.id.textdate);

        }
    }

}
