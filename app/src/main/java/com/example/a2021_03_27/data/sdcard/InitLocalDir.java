package com.example.a2021_03_27.data.sdcard;

import android.content.Context;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2021_03_27.MainActivity;
import com.example.a2021_03_27.R;

import java.util.Arrays;
import java.util.List;

public class InitLocalDir {


    public String getPath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public void createAFile(String paths){
        int result = SdcardUtil.create_File(getPath() + paths);
        //showResult(result);
    }

    public void createADirectory(String paths){
        int result = SdcardUtil.create_Dir(getPath() + paths);
        //showResult(result);
    }

    private void showResult (int result) {
        switch (result) {
            case SdcardUtil.FLAG_SUCCESS:

            case SdcardUtil.FLAG_EXISTS:

            case SdcardUtil.FLAG_FAILED:

        }
    }


    public void initProjectDir(Context context){
        List<String> list = Arrays.asList(context.getResources().getStringArray(R.array.my_file));
        for(int i = 0 ; i < list.size() ; i++ ){
            createADirectory(list.get(i));
        }
    }
}
