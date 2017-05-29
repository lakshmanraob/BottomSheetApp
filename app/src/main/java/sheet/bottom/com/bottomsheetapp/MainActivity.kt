package sheet.bottom.com.bottomsheetapp

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import sheet.bottom.com.bottomsheetapp.firebase.ReactFragment

class MainActivity : AppCompatActivity() {

    internal var mTabLayout: TabLayout? = null

    private val mTabsIcons = intArrayOf(R.drawable.ic_fav_selector, R.drawable.ic_place_selector, R.drawable.ic_recents_selector, R.drawable.ic_chat_selector)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mViewPager = findViewById(R.id.viewPager) as ViewPager

        val pageAdapter = MyPageAdapter(supportFragmentManager)

        if (mViewPager != null) {
            mViewPager.adapter = pageAdapter
        }

        mTabLayout = findViewById(R.id.tab_layout) as TabLayout
        if (mTabLayout != null) {
            mTabLayout!!.setupWithViewPager(mViewPager)

            for (i in 0..mTabLayout!!.tabCount - 1) {
                val tab = mTabLayout!!.getTabAt(i)
                if (tab != null)
                    tab.customView = pageAdapter.getTabView(i)
            }

            mTabLayout!!.getTabAt(0)!!.customView!!.isSelected = true
        }


    }

    private inner class MyPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val PAGE_COUNT = 3

        private val page_title = arrayOf("android", "IOT", "Kotlin", "ReactiveX")


        fun getTabView(position: Int): View {
            // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
            val view = LayoutInflater.from(this@MainActivity).inflate(R.layout.custom_tab, null)
            val title = view.findViewById(R.id.custom_title) as TextView
            title.text = page_title[position]
            val icon = view.findViewById(R.id.custom_icon) as ImageView
            icon.setImageResource(mTabsIcons[position])
            return view
        }

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return PageFragment.newInstance(page_title[position])
                1 -> return PageFragment.newInstance(page_title[position])
                2 -> return PageFragment.newInstance(page_title[position])
                3 -> return ReactFragment.getInstance("React")
            }
            return null
        }

        override fun getCount(): Int {
            return page_title.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return page_title[position]
        }
    }
}
