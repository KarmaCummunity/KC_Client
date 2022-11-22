package com.example.KC.ui.side.stuff;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StuffViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StuffViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("כאן תורמים כסף");
    }

    public LiveData<String> getText() {
        return mText;
    }
}