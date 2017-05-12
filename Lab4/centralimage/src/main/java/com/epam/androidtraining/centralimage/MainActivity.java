package com.epam.androidtraining.centralimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements LoadImageTask.Listener{
    private ImageView imageView;
    private TextView textView;
    private int state = 1;

    public static final String IMAGE_URL = "http://www.abhsoftware.com/images/android.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.central_image);
        textView = (TextView) findViewById(R.id.moveable_text);
        new LoadImageTask(this).execute(IMAGE_URL);

        imageView.setOnLongClickListener((v) -> moveText());
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error Loading Image !", Toast.LENGTH_SHORT).show();
    }

    public boolean moveText(){
        FrameLayout view1, view2;
        switch (state){
            case 1:
                view1 = (FrameLayout) findViewById(R.id.top_left);
                view1.removeView(textView);
                view2 = (FrameLayout) findViewById(R.id.top_right);
                view2.addView(textView);
                state++;
                break;
            case 2:
                view1 = (FrameLayout) findViewById(R.id.top_right);
                view1.removeView(textView);
                view2 = (FrameLayout) findViewById(R.id.bott_right);
                view2.addView(textView);
                state++;
                break;
            case 3:
                view1 = (FrameLayout) findViewById(R.id.bott_right);
                view1.removeView(textView);
                view2 = (FrameLayout) findViewById(R.id.bott_left);
                view2.addView(textView);
                state++;
                break;
            case 4:
                view1 = (FrameLayout) findViewById(R.id.bott_left);
                view1.removeView(textView);
                view2 = (FrameLayout) findViewById(R.id.top_left);
                view2.addView(textView);
                state = 1;
                break;
        }
        return true;
    }


}
