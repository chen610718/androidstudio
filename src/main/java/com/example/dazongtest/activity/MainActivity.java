package com.example.dazongtest.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dazongtest.R;
import com.example.dazongtest.fragment.HomeFrag;
import com.example.dazongtest.fragment.MyFrag;
import com.example.dazongtest.fragment.SearchFrag;
import com.example.dazongtest.fragment.TuanFrag;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MainActivity extends FragmentActivity {
    @ViewInject(R.id.rb_home)
    private RadioButton rb_home;
    @ViewInject(R.id.rb_tuan)
    private RadioButton rb_tuan;
    @ViewInject(R.id.rb_search)
    private RadioButton rb_search;
    @ViewInject(R.id.rb_my)
    private RadioButton rb_my;
    @ViewInject(R.id.radiogroup)
    private RadioGroup mRadioGroup;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
    }

    private void initVariable(){
        ViewUtils.inject(this);
        rb_home.setChecked(true);

//        mFragmentManager = getSupportFragmentManager();
//        mFragmentTransaction = mFragmentManager.beginTransaction();
//
//        mFragmentTransaction.add(R.id.lay_maincontent, new HomeFrag());
//        mFragmentTransaction.commit();
        getSupportFragmentManager().beginTransaction().add(R.id.lay_maincontent, new HomeFrag()).commit();
    }

    @OnClick({R.id.rb_home,R.id.rb_tuan,R.id.rb_search,R.id.rb_my})
    private void onRadioButtonClick(View view){
        switch (view.getId()){
            case R.id.rb_home:
                rb_home.setChecked(true);
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.lay_maincontent, new HomeFrag()).
                        addToBackStack(null).
                        commit();
                break;
            case R.id.rb_tuan:
                rb_tuan.setChecked(true);
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.lay_maincontent, new TuanFrag()).
                        addToBackStack(null).
                        commit();
                break;
            case R.id.rb_search:
                rb_search.setChecked(true);
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.lay_maincontent, new SearchFrag()).
                        addToBackStack(null).
                        commit();
                break;
            case R.id.rb_my:
                rb_my.setChecked(true);
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.lay_maincontent, new MyFrag()).
                        addToBackStack(null).
                        commit();
                break;
        }
    }
}
