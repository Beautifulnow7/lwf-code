package com.example.myapplication;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FrameLayout content;
    LinearLayout tabweixin,tabfriend,tabtxl,tabsetting;
    FragmentManager fragmentManager;
    weixinFragment tab01 = new weixinFragment();
    frendFragment tab02 = new frendFragment();
    txlFragment tab03 = new txlFragment();
    settingFragment tab04 = new settingFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        tabweixin = findViewById(R.id.td_tab_weixin);
        tabfriend = findViewById(R.id.td_tab_friend);
        tabtxl = findViewById(R.id.td_tab_txl);
        tabsetting = findViewById(R.id.td_tab_setting);

        content = findViewById(R.id.td_content);

        tabweixin.setOnClickListener(this);
        tabfriend.setOnClickListener(this);
        tabtxl.setOnClickListener(this);
        tabsetting.setOnClickListener(this);

        initFragment();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.td_tab_weixin:
                Log.v("hzf","第1个tab被点击");
                SelectTab(0);
                break;
            case R.id.td_tab_friend:
                Log.v("hzf","第2个tab被点击");
                SelectTab(1);
                break;
            case R.id.td_tab_txl:
                Log.v("hzf","第3个tab被点击");
                SelectTab(2);
                break;
            case R.id.td_tab_setting:
                Log.v("hzf","第4个tab被点击");
                SelectTab(3);
                break;
            default:
                break;
        }

    }







    public void SelectTab(int i){


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:transaction.show(tab01);
            break;
            case 1:transaction.show(tab02);
            break;
            case 2:transaction.show(tab03);
            break;
            case 3:transaction.show(tab04);
            break;
            default:
                break;
        }
        transaction.commit();
    }

    public void initFragment(){

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.td_content,tab01);
        transaction.add(R.id.td_content,tab02);
        transaction.add(R.id.td_content,tab03);
        transaction.add(R.id.td_content,tab04);
        transaction.commit();

    }

    public void hideFragment(FragmentTransaction transaction){
        transaction.hide(tab01);
        transaction.hide(tab02);
        transaction.hide(tab03);
        transaction.hide(tab04);

    }
}
