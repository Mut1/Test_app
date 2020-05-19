package com.mut.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "111111";
    public static final String time1 = "16:02:01";
    public static final String time3 = "16:04:22";
    private static Date date1;
    private static Date date3;
    private  long diff;
    private  long minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SimpleDateFormat("2019-09-11 11:09:11");
        SimpleDateFormat simpleDateFormat1 =new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 =new SimpleDateFormat("HH时mm分ss秒");
        SimpleDateFormat simpleDateFormat3 =new SimpleDateFormat("12:00:00");
        try {
            date1=simpleDateFormat1.parse(time1);
            date3=simpleDateFormat1.parse(time3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
         diff = date1.getTime() - date3.getTime();// 这样得到的差值是微秒级别
        minutes = diff / (1000 );
      //  long diff = ChronoUnit.MINUTES.between(date1, date3);
        String  time2 =simpleDateFormat1.format(TimeUtils.getNowDate());
        Log.e(TAG, "获取当前 Date:"+TimeUtils.getNowDate()+""); //获取当前 DateTue May 19 12:08:41 GMT+08:00 2020
        Log.e(TAG, "获取当前 String:"+TimeUtils.getNowString()+"");//获取当前 String2020-05-19 12:08:41
        Log.e(TAG, "获取当前Data 转 String （只有日期: "+simpleDateFormat1.format(TimeUtils.getNowDate())); //获取当前Data 转 String （只有日期） 12:15:56
        Log.e(TAG, "获取当前Data 转 String （只有日期: "+simpleDateFormat2.format(TimeUtils.getNowDate())); //获取当前Data 转 String （只有日期）:12时17分15秒
        Log.e(TAG, "获取时间差"+TimeUtils.getTimeSpanByNow(time1, TimeConstants.SEC)+"");
        Log.e(TAG, "获取当前 Date"+minutes+"");

    }
}
