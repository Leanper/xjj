package com.leanper.xjj.main.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.leanper.xjj.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Title: MainActivity
 * @Description:
 * @author: Leanper
 * @date: 2018/12/24 17:22
 */


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    private Unbinder bind;


    /**
     * 底部导航栏
     */
    private String[] titles = new String[]{"新知识", "优化", "view","添加项"};

    private String TAG = "MainActivity";
    //Tab标题集合
    private List<String> mTitles;

    /**
     * 图片数组
     */
    private int[] mImgs = new int[]{

            R.mipmap.icon_first,
            R.mipmap.icon_second,
            R.mipmap.icon_three,
            R.mipmap.icon_four,
            };


    // ViewPage选项卡页面集合
    private List<Fragment> mListFragments = new ArrayList<>();
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        Log.d(TAG, "onCreate: "+screenWidth+"=="+screenHeight);
        //初始化界面
        init();
    }

    /**
     * 初始化界面
     * */
    private void init() {
        mTitles = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mTitles.add(titles[i]);
        }

        mListFragments.add(new FirstFragment());
        mListFragments.add(new SecondFragment());
        mListFragments.add(new ThridFragment());
        mListFragments.add(new FouthFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager(), mListFragments, mTitles);
        mViewPager.setAdapter(adapter);//给ViewPager设置适配器
        mViewPager.setOffscreenPageLimit(3);//缓存当前界面每一侧的界面数(此方案适用于界面数较少的情况，避免缓存界面太多导致内存吃紧。)
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来
        mTabLayout.setSelectedTabIndicatorHeight(1);//tablayout底部线的高度
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);


        for (int i = 0; i < adapter.getCount(); i++) {
            //获得到对应位置的Tab
            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null) {
                //设置自定义的标题
                itemTab.setCustomView(R.layout.item_tab);
                TextView textView = (TextView) itemTab.getCustomView().findViewById(R.id.tv_name);
                textView.setText(mTitles.get(i));

                ImageView imageView = (ImageView) itemTab.getCustomView().findViewById(R.id.iv_img);
                imageView.setImageResource(mImgs[i]);


            }
        }
        mTabLayout.setOnTabSelectedListener(mOnTabSelectedListener);

    }

    /**
     * TabLayout的监听事件
     */
    TabLayout.OnTabSelectedListener mOnTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            //选中了tab的逻辑
            Animation animation= android.view.animation.AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_navation_translate);


            tab.getCustomView().startAnimation(animation);

//            if (tab.getPosition() == 2 || tab.getPosition() == 3) {
//            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            int position = tab.getPosition();

//            TextView viewById = mTabLayout.getTabAt(position).getCustomView().findViewById(R.id.tv_name);
//            viewById.setTextSize(14);
            //未选中tab的逻辑
//            if (tab.getPosition() != 0 && tab.getPosition() != 1) {
//                if (!AppData.isLoginEd() || JMessageClient.getMyInfo() == null) {
//                    CommonUtils.startActivity(MainActivity1.this, LoginActivity.class);
//                }
//            }
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            //再次选中tab的逻辑 仿取消按钮

            //再次选择之后的动画
            Animation animation= android.view.animation.AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_navation_translate_again);
            tab.getCustomView().startAnimation(animation);


        }


    };




    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
