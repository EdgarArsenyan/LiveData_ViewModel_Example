package com.noringerazancutyun.livedata_viewmodel_example;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {

    MutableLiveData<Integer> liveData;

    public MutableLiveData<Integer> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            liveData.setValue(0);
        }
        return liveData;
    }

    public void increment() {
        if (liveData.getValue() != null) {
            liveData.setValue(liveData.getValue() + 1);
        }
    }

    public void decrement() {
        if (liveData.getValue() != null) {
            liveData.setValue(liveData.getValue() - 1);
        }
    }
}
