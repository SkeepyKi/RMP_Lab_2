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

    public interface OnFragmentInteractionListener {
        void onNormalClick();
        void onClearTopClick();
        void onNewTaskClick();
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

        Button btnNormal = view.findViewById(R.id.btn_normal);
        Button btnClearTop = view.findViewById(R.id.btn_clear_top);
        Button btnNewTask = view.findViewById(R.id.btn_new_task);

        btnNormal.setOnClickListener(v -> {
            if (listener != null) listener.onNormalClick();
        });
        btnClearTop.setOnClickListener(v -> {
            if (listener != null) listener.onClearTopClick();
        });
        btnNewTask.setOnClickListener(v -> {
            if (listener != null) listener.onNewTaskClick();
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}