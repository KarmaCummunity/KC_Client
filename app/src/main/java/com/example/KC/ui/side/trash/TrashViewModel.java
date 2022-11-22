package com.example.KC.ui.side.trash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrashViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrashViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("חפשו למי תוכלו לתרום / איזה עמותה מתאימה לכם");
    }

    public LiveData<String> getText() {
        return mText;
    }
}