package com.example.KC.ui.side.time;

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

public class TimeFragment extends Fragment {

    private TimeViewModel timeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        timeViewModel =
                new ViewModelProvider(this).get(TimeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_time, container, false);
        final TextView textView = root.findViewById(R.id.link_time);
        timeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        //Uri uri = Uri.parse("https://www.hebrew.we-tribu.com"); // missing 'http://' will cause crashed
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);
        return root;
    }
}