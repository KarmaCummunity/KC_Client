package com.example.KC.ui.side.medical;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MedicalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MedicalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("כאן תורמים כסף");
    }

    public LiveData<String> getText() {
        return mText;
    }
}