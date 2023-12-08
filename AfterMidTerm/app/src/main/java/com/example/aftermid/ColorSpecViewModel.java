package com.example.aftermid;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ColorSpecViewModel extends ViewModel {
   MutableLiveData<List<ColorSpec>> ColorList = new MutableLiveData<>();
   public LiveData<List<ColorSpec>> getColorList() {
           if(ColorList == null)
           {
               ColorList = new MutableLiveData<>();
           }
         return ColorList;
   }

   public void loadColorList(List<ColorSpec> colorList)
   {
       ColorList.setValue(colorList);
//       Handler hander = new Handler();
//       hander.postDelayed(new Runnable() {
//           @Override
//           public void run() {
//               ColorList.setValue(colorList);
//           }
//       },1000);

   }

}
