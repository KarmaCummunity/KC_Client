package com.example.KC.ui.money;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.KC.R;

public class MoneyFragment extends Fragment {

    private MoneyViewModel moneyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        moneyViewModel =
                new ViewModelProvider(this).get(MoneyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_money, container, false);
        final TextView textView = root.findViewById(R.id.link_money);
        moneyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}