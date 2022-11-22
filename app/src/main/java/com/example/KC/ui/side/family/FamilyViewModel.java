package com.example.KC.ui.side.family;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FamilyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FamilyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("כאן תורמים כסף");
    }

    public LiveData<String> getText() {
        return mText;
    }
}