package com.example.dazongtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.dazongtest.R;
import com.example.dazongtest.util.ShareUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaoqinchen on 2017/3/9.
 */

public class WelcomeAct extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_welcome);
        //用Handler执行延时操作
//        new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                startActivity(new Intent(getApplication(),MainActivity.class));
//                finish();
//                return false;
//            }
//        }).sendEmptyMessageDelayed(1,3000);
        //开启定时器
        new Timer().schedule(new TaskTimer(),3000);
    }

    private class TaskTimer extends TimerTask{

        @Override
        public void run() {
            if(ShareUtil.getShareIsFirst(getApplication())) {
                startActivity(new Intent(getApplication(), WelcomeGuigeAct.class));
                ShareUtil.setShareIsFirst(getApplication(),false);
            }else {
                startActivity(new Intent(getApplication(),MainActivity.class));
            }
            finish();
        }
    }
}
