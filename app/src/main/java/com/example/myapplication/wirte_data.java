package com.example.myapplication;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class wirte_data extends Thread {
    Context context;
    ArrayList<score_struct> data;
    File floder;
    String name;
    wirte_data(Context context, ArrayList<score_struct> i,File floder,String name)
    {
        this.context=context;
        this.data=i;
        this.floder=floder;
        this.name=name;
    }

    @Override
    public void run() {
        super.run();
        File sdcard= floder;
            try
            {
                if(!sdcard.exists())
                sdcard.mkdirs();
                File output=new File(sdcard,name+".csv");
                FileOutputStream outputStream=new FileOutputStream(output);
                if(!output.exists())
                output.createNewFile();
                StringBuilder ouputdata=new StringBuilder();
                for(int k=0;k<data.size();k++)
                {
                    ouputdata.append(data.get(k).name+",");
                    for(int g=0;g<data.get(k).score.size();g++)
                    {
                        ouputdata.append(data.get(k).score.get(g));
                        if(g==data.get(k).score.size()-1)
                            ouputdata.append("\n");
                        else
                            ouputdata.append(",");
                    }
                }
                outputStream.write(ouputdata.toString().getBytes());
                outputStream.flush();
                outputStream.close();
                Toast.makeText(context, ""+floder, Toast.LENGTH_LONG).show();
                //Log.e("123","123");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


    }
}
