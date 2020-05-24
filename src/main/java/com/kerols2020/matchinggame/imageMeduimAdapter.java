package com.kerols2020.matchinggame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.kerols2020.matchinggame.R;

public class imageMeduimAdapter extends BaseAdapter {


    private Context context ;
    public  int images[]={
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
            R.drawable.question_mark

    };

    public imageMeduimAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(120,120));

        return imageView;
    }
}

