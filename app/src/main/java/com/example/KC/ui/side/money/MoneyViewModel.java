package com.example.KC.ui.side.money;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoneyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MoneyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("כאן תורמים כסף");
    }

    public LiveData<String> getText() {
        return mText;
    }
}