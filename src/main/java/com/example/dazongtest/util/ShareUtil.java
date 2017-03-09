package com.example.dazongtest.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xiaoqinchen on 2017/3/9.
 */

public class ShareUtil {
    private static String FILE_NAME = "sharefile";
    private static String ISFIRST_KEY = "isfirst";


    public static boolean getShareIsFirst(Context pContext){
        return pContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).getBoolean(ISFIRST_KEY,true);
    }

    public static void setShareIsFirst(Context pContext,boolean pIsFirst){
        SharedPreferences.Editor _editor = pContext.getSharedPreferences(FILE_NAME,Context.MODE_APPEND).edit();
        _editor.putBoolean(ISFIRST_KEY,pIsFirst);
        _editor.commit();
    }
}
