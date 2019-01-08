package com.leanper.xjj.main.view.state;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewStub;


/**
 * @Title:  AbsViewStubLayout 
 
 * @Description:    
 * @author:  Leanper
 * @date:   2019/1/7 8:58
 
 */  
public abstract class AbsViewStubLayout {

    protected ViewStub mLayoutVs;

    protected View mContentView;

    protected void initLayout(Context context , @LayoutRes int layoutResId) {
        mLayoutVs = new ViewStub(context);
        mLayoutVs.setLayoutResource(layoutResId);
    }

    protected ViewStub getLayoutVs() {
        return mLayoutVs;
    }

    protected void setView(View contentView) {
        mContentView = contentView;
    }

    /**
     * 设置数据
     * @param objects           数据
     */
    protected abstract void setData(Object... objects);
}
