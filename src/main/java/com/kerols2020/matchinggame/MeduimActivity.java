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

public class MeduimActivity extends AppCompatActivity {

    GridView gridView;
    TextView textView;
    int temp=-1 ,P1=-1,PP;
    View V=null,VV;
    int images[]={R.drawable.horse,
            R.drawable.plane,
            R.drawable.cup,
            R.drawable.dolephen,
            R.drawable.star,
            R.drawable.lion,
            R.drawable.moon,
            R.drawable.bag,
            R.drawable.moon,
            R.drawable.dolephen,
            R.drawable.plane,
            R.drawable.horse,
            R.drawable.rocket,
            R.drawable.star,
            R.drawable.panda,
            R.drawable.lion,
            R.drawable.panda,
            R.drawable.rocket,
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
            R.drawable.question_mark};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meduim);
        gridView =findViewById(R.id.GrideM);
        gridView.setAdapter(new imageMeduimAdapter(MeduimActivity.this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DoAlgo(position,view);
            }
        });
        textView=findViewById(R.id.nextM);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfGamefinish())
                {
                    startActivity(new Intent(MeduimActivity.this,HardActivity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"finish the game firstly",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    boolean checkIfGamefinish()
    {
        boolean flag=true;
        for (int x=0;x<20;x++)
        {
            if (templetes[x]!=R.drawable.question_mark)
                continue;
            else
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
    public void DoAlgo(int position,View view)
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
                    public void run(){ // open second image fo 600 millisecond
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
