package com.example.finalpractice;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class PhoneViewModel extends ViewModel {

    MutableLiveData<List<Phone>> phoneList = new MutableLiveData<List<Phone>>();
    public LiveData<List<Phone>> getPhoneList() {
      if(phoneList == null)
      {
          phoneList = new MutableLiveData<>();
      }
        return  phoneList;
    }

    public void loadColorList(List<Phone> phoneList1)
    {
        phoneList.setValue(phoneList1);
    }





}
