package com.leanper.xjj.main.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leanper.xjj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Title: ThridFragment
 * @Description:
 * @author: Leanper
 * @date: 2018/12/25 9:39
 */
public class FouthFragment extends Fragment {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;
    @BindView(R.id.additem_recyclerview)
    RecyclerView additemRecyclerview;
    private View mFragmentView;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_four, container, false);
        bind = ButterKnife.bind(this, mFragmentView);
        init();
        return mFragmentView;
    }

    //初始化方法
    private void init() {
        tvTitle.setText("添加项");
        tvTitle.setTextColor(Color.BLACK);

        //创建添加项的个项列表

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }


}
