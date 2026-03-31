package com.example.lab_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.otto.Subscribe;

public class NameFragment extends BaseFragment {

    private OnNameEnteredListener listener;

    public interface OnNameEnteredListener {
        void onNameEntered(String name);
    }

    @Override
    public void onAttach(@NonNull android.content.Context context) {
        super.onAttach(context);
        if (context instanceof OnNameEnteredListener) {
            listener = (OnNameEnteredListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnNameEnteredListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);

        EditText editName = view.findViewById(R.id.editName);
        Button btnNext = view.findViewById(R.id.btn_next);

        btnNext.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            if (!name.isEmpty() && listener != null) {
                listener.onNameEntered(name);
            }
        });

        return view;
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(getActivity(), "NameFragment получил: " + event.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}