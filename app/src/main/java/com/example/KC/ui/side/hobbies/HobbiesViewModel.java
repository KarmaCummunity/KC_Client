package com.example.KC.ui.side.hobbies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HobbiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HobbiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("כאן תורמים כסף");
    }

    public LiveData<String> getText() {
        return mText;
    }
}