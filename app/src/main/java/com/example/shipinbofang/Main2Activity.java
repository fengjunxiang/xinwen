package com.example.shipinbofang;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.shipinbofang.BlankFragment;
import com.example.shipinbofang.R;
import java.util.ArrayList;
import java.util.List;
public class Main2Activity extends AppCompatActivity {

   private static final String TAG="Main2Activity";
    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("今日");

        initView();
    }

    private void initView() {

        // find view

        mViewPager = (ViewPager) findViewById(R.id.fragment_vp);

        mTabRadioGroup =(RadioGroup) findViewById(R.id.tabs_rg);//强制类型转换


        // init fragment
        mFragments = new ArrayList<>(4);

        //定义两个视图，两个视图都加载同一个布局文件list_view.ml


        mFragments.add(ListviewFragment.newInstance());

        mFragments.add(BlankFragment.newInstance("记录"));

        mFragments.add(BlankFragment.newInstance("通讯录"));

       mFragments.add(BlankFragment.newInstance("设置"));


        // init view pager

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments);

        mViewPager.setAdapter(mAdapter);


        // register listener

        mViewPager.addOnPageChangeListener(mPageChangeListener);

        mTabRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);

    }



    @Override

    protected void onDestroy() {

        super.onDestroy();
        mViewPager.removeOnPageChangeListener(mPageChangeListener);

    }



    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



        }



        @Override

        public void onPageSelected(int position) {

            RadioButton radioButton = (RadioButton) mTabRadioGroup.getChildAt(position);

            radioButton.setChecked(true);

        }



        @Override

        public void onPageScrollStateChanged(int state) {



        }

    };



    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override

        public void onCheckedChanged(RadioGroup group, int checkedId) {

            for (int i = 0; i < group.getChildCount(); i++) {

                if (group.getChildAt(i).getId() == checkedId) {//滑动效果

                    mViewPager.setCurrentItem(i);
                    if(i==0)
                    {

                        getSupportActionBar().setTitle("今日");
                    }
                    if(i==1)
                    {
                        getSupportActionBar().setTitle("视频");
                    }
                    if(i==2)
                    {
                        getSupportActionBar().setTitle("热点");
                    }
                    if(i==3)
                    {
                        getSupportActionBar().setTitle("我");
                    }
                    Log.d(TAG,"i");
                    return;
                }
            }
        }

    };



    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {



        private List<Fragment> mList;



        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {

            super(fm);

            this.mList = list;

        }



        @Override
        public Fragment getItem(int position) {

            return this.mList == null ? null : mList.get(position);

        }



        @Override

        public int getCount() {

            return this.mList == null ? 0 : this.mList.size();

        }

    }



}
