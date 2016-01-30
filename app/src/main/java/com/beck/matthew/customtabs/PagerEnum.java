/**
Copyright 2016 mattwolf1234

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/
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
