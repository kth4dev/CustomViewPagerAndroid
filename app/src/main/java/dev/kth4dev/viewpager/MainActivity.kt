package dev.kth4dev.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import dev.kth4dev.viewpager.fragments.OneFragment
import dev.kth4dev.viewpager.fragments.ThreeFragment
import dev.kth4dev.viewpager.fragments.TwoFragment
import dev.kth4dev.viewpager.viewpagerHelper.ViewPagerAdapter
import dev.kth4dev.viewpager.viewpagerHelper.ViewPager

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button
    private val fragmentList = listOf<Fragment>(OneFragment(), TwoFragment(), ThreeFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setUpViewPager()
        onClick()
    }

    private fun onClick() {
        btnNext.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1, false)
        }
        btnBack.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem - 1, false)
        }
    }

    private fun setUpViewPager() {
        viewPager.adapter = ViewPagerAdapter(fragmentList, this.supportFragmentManager)
        viewPager.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        btnNext.visibility = View.VISIBLE
                        btnBack.visibility = View.GONE
                    }
                    1 -> {
                        btnNext.visibility = View.VISIBLE
                        btnBack.visibility = View.VISIBLE
                    }
                    2 -> {
                        btnNext.visibility = View.GONE
                        btnBack.visibility = View.VISIBLE
                    }
                }
            }


        })
    }

    private fun init() {
        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btn_next)
        btnBack = findViewById(R.id.btn_back)


    }

}