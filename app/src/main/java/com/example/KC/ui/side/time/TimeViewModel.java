package com.example.KC.ui.side.time;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TimeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("https://www.hebrew.we-tribu.com/");
    }

    public LiveData<String> getText() {
        return mText;
    }
}