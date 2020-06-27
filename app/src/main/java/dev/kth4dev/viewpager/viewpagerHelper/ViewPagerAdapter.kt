package dev.kth4dev.viewpager.viewpagerHelper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fl: List<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList = fl

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}