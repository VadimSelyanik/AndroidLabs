package com.epam.androidtraining.lab3frag;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * Created by vadim on 09.05.17.
 */

public class MyFragment extends Fragment {
    final int [] colors = {Color.LTGRAY,Color.RED, Color.BLACK, Color.BLUE, Color.CYAN,Color.GREEN,
            Color.DKGRAY,Color.MAGENTA,Color.WHITE,Color.YELLOW};
    final String FRAGMENT_TAG = "MyFragment";

    final String BUTTON1_STATE = "button1Color";
    final String BUTTON2_STATE = "button2Color";
    final String BUTTON3_STATE = "button3Color";
    Button button1;
    Button button2;
    Button button3;
    int color1, color2, color3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(FRAGMENT_TAG, "On Create View");
        View view = inflater.inflate(R.layout.fragment_layout,container,false);
        final Random random = new Random(System.currentTimeMillis());

        button1 = (Button) view.findViewById(R.id.button1);
        button1.setBackgroundColor(colors[color1]);
        button2 = (Button) view.findViewById(R.id.button2);
        button2.setBackgroundColor(colors[color2]);
        button3 = (Button) view.findViewById(R.id.button3);
        button3.setBackgroundColor(colors[color3]);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color1 = Math.abs(random.nextInt()%10);
                button1.setBackgroundColor(colors[color1]);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color2 = Math.abs(random.nextInt()%10);
                button2.setBackgroundColor(colors[color2]);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color3 = Math.abs(random.nextInt()%10);
                button3.setBackgroundColor(colors[color3]);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUTTON1_STATE, color1);
        outState.putInt(BUTTON2_STATE, color2);
        outState.putInt(BUTTON3_STATE, color3);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        Log.d(FRAGMENT_TAG, "On Create");

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            color1 = savedInstanceState.getInt(BUTTON1_STATE);
            color2 = savedInstanceState.getInt(BUTTON2_STATE);
            color3 = savedInstanceState.getInt(BUTTON3_STATE);
        } else {
            color1 = 0;
            color2 = 0;
            color3 = 0;
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(FRAGMENT_TAG, "On Start");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(FRAGMENT_TAG, "On Resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(FRAGMENT_TAG, "On Pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(FRAGMENT_TAG, "On Stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(FRAGMENT_TAG, "On Destroy");
    }
}
