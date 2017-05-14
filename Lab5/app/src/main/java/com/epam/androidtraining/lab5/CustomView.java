package com.epam.androidtraining.lab5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vadim on 14.05.17.
 */

public class CustomView extends View {
    private Paint smile;

    public CustomView(Context context) {
        super(context);
        smile = new Paint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        smile = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        smile.setColor(ContextCompat.getColor(getContext(),R.color.font));
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),smile);
        smile.setColor(ContextCompat.getColor(getContext(),R.color.smile_color));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(canvas.getWidth()/7,canvas.getHeight()/4,6*canvas.getWidth()/7,3*canvas.getHeight()/4,smile);
            smile.setColor(Color.BLACK);
            canvas.drawOval(canvas.getWidth()/4,canvas.getHeight()/3,
                    canvas.getWidth()/4+canvas.getHeight()/35,canvas.getHeight()/3+canvas.getHeight()/35,
                    smile);
            canvas.drawOval(3*canvas.getWidth()/4,canvas.getHeight()/3,
                    3*canvas.getWidth()/4+canvas.getHeight()/35,canvas.getHeight()/3+canvas.getHeight()/35,
                    smile);
            smile.setStyle(Paint.Style.STROKE);
            smile.setStrokeWidth(20);
            canvas.drawArc(canvas.getWidth()/4,canvas.getHeight()/2,
                    3*canvas.getWidth()/4,6*canvas.getHeight()/7,(float)185,(float)170,false,smile);
        }
    }
}
