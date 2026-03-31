package com.example.lab_2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    // Интерфейс для связи с Activity
    public interface OnFragmentInteractionListener {
        void onButton1Clicked();
        void onButton2Clicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btn1 = view.findViewById(R.id.btn_activity1);
        Button btn2 = view.findViewById(R.id.btn_activity2);

        btn1.setOnClickListener(v -> {
            if (listener != null) listener.onButton1Clicked();
        });

        btn2.setOnClickListener(v -> {
            if (listener != null) listener.onButton2Clicked();
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}