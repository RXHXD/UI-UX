package com.example.finalpractice;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class PhoneViewModel extends ViewModel {

    MutableLiveData<List<Phone>> phoneList = new MutableLiveData<List<Phone>>();
    MutableLiveData<List<DeepPhone>> phoneList1 = new MutableLiveData<List<DeepPhone>>();

    public LiveData<List<Phone>> getPhoneList() {
      if(phoneList == null)
      {
          phoneList = new MutableLiveData<>();

      }
        return  phoneList;
    }

    public LiveData<List<DeepPhone>> getPhoneList1() {
        if(phoneList == null)
        {
            phoneList1 = new MutableLiveData<>();

        }
        return  phoneList1;
    }




    public void loadColorList(List<Phone> phoneList1)
    {
        phoneList.setValue(phoneList1);
    }

    public void loadColorList1(List<DeepPhone> phoneList2)
    {
        phoneList1.setValue(phoneList2);
    }




}
