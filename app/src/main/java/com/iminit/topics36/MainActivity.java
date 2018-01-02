package com.iminit.topics36;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vp_content);
        viewPager.setAdapter(new MyAdapter());
    }

    /**
     * 自定义类实现PagerAdapter，填充显示数据
     */
    class MyAdapter extends PagerAdapter {

        // 显示多少个页面
        @Override
        public int getCount() {
            return CS.topics.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // 初始化显示的条目对象
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 准备显示的数据，一个简单的TextView
            TextView tv = new TextView(MainActivity.this);

            int i = Color.parseColor(CS.colors[getNextRandom(colorCurrentIndex)]);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(20, 20, 20, 20);
            tv.setTextSize(42);
            tv.setTextColor(i);
            tv.setText(CS.topics[position]);
            container.addView(tv);
            return tv;
        }


        // 销毁条目对象
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private int colorCurrentIndex = 0;

    private int getNextRandom(int oldColorIndex) {
        int index = (int) Math.ceil(Math.random() * (CS.colors.length - 1));
        if (index == oldColorIndex) {
            index = getNextRandom(index);
        }
        colorCurrentIndex = index;
        return index;
    }
}
