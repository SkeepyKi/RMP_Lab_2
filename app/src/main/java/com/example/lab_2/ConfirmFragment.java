package com.example.lab_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.otto.Subscribe;

public class ConfirmFragment extends BaseFragment {

    public static ConfirmFragment newInstance(String name, String topic) {
        ConfirmFragment fragment = new ConfirmFragment();
        Bundle args = new Bundle();
        args.putString("user_name", name);
        args.putString("topic", topic);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);

        TextView tvInfo = view.findViewById(R.id.tv_info);
        Button btnFinish = view.findViewById(R.id.btn_finish);

        if (getArguments() != null) {
            String name = getArguments().getString("user_name");
            String topic = getArguments().getString("topic");
            tvInfo.setText(name + ", вы выбрали тему: " + topic + "\n\nНажмите Завершить, чтобы выйти.");
        }

        btnFinish.setOnClickListener(v -> {
            requireActivity().finish();
        });

        return view;
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(getActivity(), "ConfirmFragment получил: " + event.getText(), Toast.LENGTH_SHORT).show();
    }
}