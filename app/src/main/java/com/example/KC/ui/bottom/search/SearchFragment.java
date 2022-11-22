package com.example.KC.ui.bottom.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.KC.R;

public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;
    private SearchView searchView;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.search_fragment, container, false);

        searchView = root.findViewById(R.id.search_view);
        searchView.setFocusedByDefault(true);
        searchView.setOnClickListener(new SearchView.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchView.setFocusedByDefault(true);
                searchView.setFocusable(true);            }
        });
        return root;
    }


}