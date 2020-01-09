package com.example.myapplication;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class wirte_data extends Thread {
    Context context;
    wirte_data(Context context)
    {
        this.context=context;
    }

    @Override
    public void run() {
        super.run();
        Log.e("123","123");
        File sdcard= Environment.getExternalStorageDirectory();
            try
            {
                if(!sdcard.exists())
                sdcard.mkdirs();
                File output=new File(sdcard,"ouput.txt");
                FileOutputStream outputStream=new FileOutputStream(output);
                if(!output.exists()) output.createNewFile();
                outputStream.write(123);
                outputStream.flush();
                outputStream.close();
                Toast.makeText(context, "輸出完成", Toast.LENGTH_LONG).show();
                Log.e("123","123");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


    }
}
