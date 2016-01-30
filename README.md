# NoFragmentTabs
This is a highly customized android tab that doesn't use fragments

You can not use fragment if you've had enough of them. Also you can have text and a icon in these tabs unlike the normal default tabs in the android sdk.

To setup more than two tabs do these steps.

1. Create a new layout file.

2. Go into the PagerEnum class and add the layout as a item

3. In main_layout add a include tag like the other ones you will see in it. All you have to change is the id.

4. In MainActivity add: setupTab("name", R.id.tab_id, R.drawable.icon);

5. Lastly in viewPager.addOnLayoutChangeListener, add the else if statement to initlize any views.


Note: You have to initlize any listviews, or adapter in the TabPagerAdapter class.
