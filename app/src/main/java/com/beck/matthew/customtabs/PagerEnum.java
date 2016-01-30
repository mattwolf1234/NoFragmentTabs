package com.beck.matthew.customtabs;

public enum PagerEnum {
/*
Place your new tabs that you create here, title only matters if you use it. 
Remember to place a comma between items
*/

    TAB1("tab1", R.layout.tab1_layout),
    TAB2("tab2", R.layout.tab2_layout);

    private String mTitle;
    private int mLayoutResId;

    PagerEnum(String title, int layoutResId) {
        mTitle = title;
        mLayoutResId = layoutResId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

    public static int length() {
        return values().length;
    }

}