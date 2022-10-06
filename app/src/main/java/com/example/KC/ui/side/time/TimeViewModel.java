package com.example.KC.ui.side.time;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TimeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("חפשו למי תוכלו לתרום / איזה עמותה מתאימה לכם");
    }

    public LiveData<String> getText() {
        return mText;
    }
}