package com.leanper.xjj.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leanper.xjj.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * @Title:  ThridFragment 
 
 * @Description:    
 * @author:  Leanper
 * @date:   2018/12/25 9:48
 
 */  
public class ThridFragment extends Fragment {

    private View mFragmentView;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         mFragmentView = inflater.inflate(R.layout.fragment_three, container, false);
        bind = ButterKnife.bind(this, mFragmentView);
        return mFragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
