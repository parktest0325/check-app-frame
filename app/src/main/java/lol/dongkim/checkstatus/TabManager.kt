package lol.dongkim.checkstatus

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabManager(private val nativeLib: NativeLib, private val fragmentActivity: FragmentActivity) {
    data class TabInfo(val name: String, val initializer: TabInitializer)

    private val tabs = mutableListOf<TabInfo>()

    init {
        // TODO: Add Tab Here!!
        addTab("Tab 1", Tab1Initializer(nativeLib))
        addTab("Tab 2", Tab2Initializer(nativeLib))
    }

    private fun addTab(name: String, initializer: TabInitializer) {
        tabs.add(TabInfo(name, initializer))
    }

    fun getTabCount() = tabs.size

    private fun getTabName(position: Int) = tabs.getOrNull(position)?.name ?: "Unknown Tab"

    fun getInitializer(position: Int) = tabs.getOrNull(position)?.initializer ?: DefaultTabInitializer()

    fun setupWithViewPager(viewPager: ViewPager2, tabLayout: TabLayout) {
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabName(position)
        }.attach()
    }

    inner class ViewPagerAdapter(private val tabManager: TabManager) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = tabManager.getTabCount()

        override fun createFragment(position: Int): Fragment {
            return TabFragment.newInstance(position)
        }
    }
}