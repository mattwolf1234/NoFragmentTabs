package com.beck.matthew.customtabs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TabHost;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends Activity {

    private TabHost tabHost;
    private ViewPager viewPager;
    boolean[] hasOpened;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        setupTab("Tab1", R.id.tab1, R.mipmap.ic_launcher);
        setupTab("Tab 2", R.id.tab2, R.mipmap.ic_launcher);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                viewPager.setCurrentItem(tabHost.getCurrentTab());
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new TabPagerAdapter(this));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //ignore
            }

            @Override
            public void onPageSelected(int position) {
                tabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //ignore
            }
        });
        viewPager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {// The point of initailizing everything here is because not every layout is made
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                int current = viewPager.getCurrentItem();
                if (current == 0) {
                    if (hasOpened[current]) {
                        // initalize any objects, buttons, views here
                        // any listviews and adapters have to be initalized in the TabPagerAdapter class
                        // you can just create a static object to access it from mainactivity
                    }
                }else if (current == 1){
                    if (hasOpened[current]){

                    }
                }
            }
        });

        hasOpened = new boolean[PagerEnum.length()];
        Arrays.fill(hasOpened, true);
    }

    private void setupTab(final String tag, int layout, int imageResource) {
        View tabView = createTabView(tabHost.getContext(), tag, imageResource);
        TabHost.TabSpec setContent = tabHost.newTabSpec(tag).setIndicator(tabView).setContent(layout);
        tabHost.addTab(setContent);
    }

    private static View createTabView(final Context context, final String text, int imageResource) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.tabsText);
        textView.setText(text);
        ImageView imageView = (ImageView) view.findViewById(R.id.tabsImage);
        imageView.setImageResource(imageResource);
        return view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
