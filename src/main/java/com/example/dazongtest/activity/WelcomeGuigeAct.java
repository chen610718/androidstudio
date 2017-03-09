package com.example.dazongtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dazongtest.R;
import com.example.dazongtest.activity.MainActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoqinchen on 2017/3/9.
 */

public class WelcomeGuigeAct extends Activity {
    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;
    @ViewInject(R.id.btn_into)
    private Button  btn_into;

    private List<View> mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_wel_guide);
        ViewUtils.inject(this);
        initViewPager();
    }

    private void initViewPager(){
        mList = new ArrayList<>();
        ImageView _imageView1 = new ImageView(this);
        ImageView _imageView2 = new ImageView(this);
        ImageView _imageView3 = new ImageView(this);
        _imageView1.setImageResource(R.drawable.guide_01);
        mList.add(_imageView1);
        _imageView2.setImageResource(R.drawable.guide_02);
        mList.add(_imageView2);
        _imageView3.setImageResource(R.drawable.guide_03);
        mList.add(_imageView3);

        viewPager.setAdapter(new MyPagerAdapter());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == mList.size()-1){
                    btn_into.setVisibility(View.VISIBLE);
                }else {
                    btn_into.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    class MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
//            destroyItem(viewPager,position,mImgRes[]);
            container.removeView(mList.get(position));
        }
    }

    @OnClick(R.id.btn_into)
    public void onBtnClick(View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
