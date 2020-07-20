package com.coding.pixel.ca.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class TabsPagerAdapter extends FragmentPagerAdapter {


    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                //HomeFragment homeFragment = new HomeFragment();
                //return homeFragment;
            case 1:
                //CareersFragment careersFragment = new CareersFragment();
                //return careersFragment;
            case 2:
                //JobsFragment jobsFragment = new JobsFragment();
                //return jobsFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3; // 3 is total fragment number (e.x- Chats, Requests)
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "HOME"; // HomeFragment
            case 1:
                return "CAREERS"; // JobsFragment
            case 2:
                return "JOBS"; // CareersFragment
            default:
                return null;
        }
        //return super.getPageTitle(position);
    }
}
