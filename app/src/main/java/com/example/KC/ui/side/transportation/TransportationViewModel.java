package com.example.KC.ui.side.transportation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransportationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TransportationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("כאן תורמים תחבורה");
    }

    public LiveData<String> getText() {
        return mText;
    }
}