package com.example.dazongtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dazongtest.R;
import com.example.dazongtest.view.SlideBar;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by xiaoqinchen on 2017/3/9.
 */

public class CityLoctionAct extends Activity implements SlideBar.OnSlideBarMoveListener{
    @ViewInject(R.id.lv_city)
    private ListView mlv_city;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cityloc);
        ViewUtils.inject(this);
    }

    private void initListener(){
    }

    private class MyListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder _holder;
            if (convertView==null){
                convertView = LayoutInflater.from(getApplication()).inflate(R.layout.item_cityloc,null);
                _holder = new Holder();
                convertView.setTag(_holder);
            }else {
                _holder = (Holder) convertView.getTag();
            }

            return convertView;
        }

        class Holder{
            @ViewInject(R.id.tv_cityindex)
            TextView tv_cityindex;
            @ViewInject(R.id.tv_cityname)
            TextView tv_cityname;
        }
    }

    @Override
    public void onSlideBarMoving(String pLetter) {

    }
}
