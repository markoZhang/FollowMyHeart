package com.example.marko.followmyheart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.example.marko.followmyheart.activity.OriginalSectionActivity;
import com.example.marko.followmyheart.adapter.section.SectionBean;
import com.example.marko.followmyheart.adapter.section.SectionRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MainActivity中的主要功能：
 * 通过BaseQuickAdapter + RecyclerView实现九宫格式的布局，并添加点击事件
 */

public class MainActivity extends MyApp {

    @BindView(R.id.rv_section)
    RecyclerView rvSection;
    @BindView(R.id.fl_recycler_view)
    FrameLayout flRecyclerView;
    private SectionRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvSection.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new SectionRecyclerViewAdapter(getData());
        rvSection.setAdapter(adapter);
        adapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (position) {
                case 0:
                    switchActivity(OriginalSectionActivity.class);
                    break;
                default:
                    break;
            }
        });
    }

    private List<SectionBean> getData() {
        List<SectionBean> datas = new ArrayList<>();
        datas.add(new SectionBean(R.drawable.student, "学生卡"));
        datas.add(new SectionBean(R.drawable.recharge, "深圳通卡充值"));
        datas.add(new SectionBean(R.drawable.balance, "卡余额查询"));
        datas.add(new SectionBean(R.drawable.icon_diy, "DIY卡"));
        datas.add(new SectionBean(R.drawable.card_shop, "普卡商城"));
        datas.add(new SectionBean(R.drawable.invoice, "电子发票"));
        datas.add(new SectionBean(R.drawable.subway, "地铁查询"));
        datas.add(new SectionBean(R.drawable.icon_duijiang, "兑券中心"));
        return datas;
    }

    private void switchFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_recycler_view,fragment)
                .commit();
    }
    private void switchActivity(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
}
