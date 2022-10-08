package com.example.KC.ui.side.money;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.KC.R;

import java.util.Random;

public class MoneyFragment extends Fragment {

    private MoneyViewModel moneyViewModel;
    private LinearLayout linearLayout;
    private int i=0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        moneyViewModel = new ViewModelProvider(this).get(com.example.KC.ui.side.money.MoneyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_money, container, false);
        final TextView textView = root.findViewById(R.id.link_money);
        moneyViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        linearLayout = root.findViewById(R.id.image);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.jgive.com"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                Handler hendler = new Handler();
                try {
                    i++;
                    hendler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (i == 2) {
                                startActivity(intent);
                                i=0;
                            }
                            i=0;
                        }
                    }, 500);
                }
                catch (Exception e) { e.printStackTrace(); }
            }
        });
        return root;
    }
}