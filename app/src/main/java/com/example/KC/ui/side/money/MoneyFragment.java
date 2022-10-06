package com.example.KC.ui.side.money;

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
import com.example.KC.ui.bottom.home.HomeViewModel;

public class MoneyFragment extends Fragment {

    private MoneyViewModel moneyViewModel;
    private HomeViewModel homeViewModel;


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
        //Uri uri = Uri.parse("https://www.jgive.com"); // missing 'http://' will cause crashed
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);
        return root;
    }
}