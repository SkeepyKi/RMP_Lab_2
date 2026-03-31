package com.example.lab_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TopicFragment extends Fragment {

    private OnTopicSelectedListener listener;
    private String userName;

    public static TopicFragment newInstance(String name) {
        TopicFragment fragment = new TopicFragment();
        Bundle args = new Bundle();
        args.putString("user_name", name);
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnTopicSelectedListener {
        void onTopicSelected(String topic);
    }

    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        if (context instanceof OnTopicSelectedListener) {
            listener = (OnTopicSelectedListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnTopicSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);

        if (getArguments() != null) {
            userName = getArguments().getString("user_name");
            TextView tvWelcome = view.findViewById(R.id.tv_welcome);
            tvWelcome.setText("Привет, " + userName + "! Выбери тему:");
        }

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        Button btnNext = view.findViewById(R.id.btn_next);

        btnNext.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selected = view.findViewById(selectedId);
                String topic = selected.getText().toString();
                if (listener != null) listener.onTopicSelected(topic);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}