package com.beck.matthew.customtabs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

public class TabPagerAdapter extends PagerAdapter {

    private Context mContext;
    ViewGroup[] layouts;

    public TabPagerAdapter(Context context) {
        mContext = context;
        layouts = new ViewGroup[PagerEnum.length()];
        Arrays.fill(layouts, null);
    }

    public Object instantiateItem(ViewGroup collection, int position) {
        PagerEnum pagerEnum = PagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout;
        if (layouts[position] != null) {
            layout = layouts[position];// Here its just set to the previouse layout that was inflated
        } else {
            layout = (ViewGroup) inflater.inflate(pagerEnum.getLayoutResId(), collection, false);// inflates the layout
            layouts[position] = layout;// saves the layout in the array
            /*
            Here place any ListView adapters and initalize them.
			This is because of some bugs. Adapters that are updated in another class will have to have a static adapter
			*/
        }
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return PagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        PagerEnum pagerEnum = PagerEnum.values()[position];
        return pagerEnum.getTitle();
    }
}