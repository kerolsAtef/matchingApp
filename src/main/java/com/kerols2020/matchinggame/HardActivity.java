package com.kerols2020.matchinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HardActivity extends AppCompatActivity {

    GridView gridView;
    TextView next;
    int temp=-1 ,P1=-1,PP;
    View V=null,VV;
    int images[]={
            R.drawable.heart,
            R.drawable.horse,
            R.drawable.plane,
            R.drawable.fish,
            R.drawable.cup,
            R.drawable.dolephen,
            R.drawable.star,
            R.drawable.lion,
            R.drawable.moon,
            R.drawable.bag,
            R.drawable.bus,
            R.drawable.bus,
            R.drawable.moon,
            R.drawable.boon,
            R.drawable.chemistry,
            R.drawable.dolephen,
            R.drawable.plane,
            R.drawable.horse,
            R.drawable.rocket,
            R.drawable.heart,
            R.drawable.boon,
            R.drawable.star,
            R.drawable.panda,
            R.drawable.fish,
            R.drawable.lion,
            R.drawable.panda,
            R.drawable.rocket,
            R.drawable.chemistry,
            R.drawable.cup,
            R.drawable.bag

    };
    int templetes[]={
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark,
            R.drawable.question_mark};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        gridView =findViewById(R.id.GrideH);
        gridView.setAdapter(new imageHardAdapter(HardActivity.this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DoAlgo(position,view);
            }
        });
        next=findViewById(R.id.nextH);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(HardActivity.this,MainActivity.class));
                    finish();

            }
        });

    }
    public void DoAlgo(int position, View view)
    {
        if (templetes[position]==R.drawable.question_mark) // if true this mean this image is uncovered
        {
            if (temp == -1 && P1 == -1 && V == null) // this mean that is first click after after last 2
            {
                ImageView imageView = (ImageView) view;
                imageView.setImageResource(images[position]);
                temp = images[position];//
                P1 = position;         //  here store informaton about first image to compare it with second image
                V = view;              //
            }
            else
            {
                VV=view;
                PP=position;
                ImageView imageView = (ImageView) VV;
                imageView.setImageResource(images[PP]);
                Runnable r = new Runnable() {
                    @Override
                    public void run(){ // open second image fo 300 millisecond
                        if (temp == images[PP])
                        {
                            templetes[PP]=images[PP];
                            templetes[P1]=images[P1];
                            temp = -1;
                            P1 = -1;
                            V = null;
                        }
                        else
                        {
                            ImageView imageView ;
                            imageView = (ImageView) VV;
                            ImageView imageView2 = (ImageView) V;
                            imageView.setImageResource(R.drawable.question_mark);
                            imageView2.setImageResource(R.drawable.question_mark);
                            temp = -1;
                            P1 = -1;
                            V = null;
                        }

                    }
                };
                Handler h = new Handler();
                h.postDelayed(r, 300);

            }
        }

    }
}
