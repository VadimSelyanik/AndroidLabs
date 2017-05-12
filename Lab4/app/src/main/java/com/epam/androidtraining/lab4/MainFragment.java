package com.epam.androidtraining.lab4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by vadim on 10.05.17.
 */

public class MainFragment extends Fragment {
    private OnChangeButtonListener mainActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        Button changeFragmentButton = (Button) view.findViewById(R.id.change_fragment_button);
        changeFragmentButton.setOnClickListener(v -> mainActivity.onChangeFragmentButtonClicked());
        Button changeColorButton = (Button) view.findViewById(R.id.change_color_button);
        changeColorButton.setOnClickListener((v) -> mainActivity.onChangeColorButtonClicked());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mainActivity = (OnChangeButtonListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException();

        }
    }

    public interface OnChangeButtonListener{
        void onChangeFragmentButtonClicked();
        void onChangeColorButtonClicked();
    }
}
