package lol.dongkim.checkstatus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var btnRunAll: Button
    private lateinit var btnClearAll: Button
    lateinit var tabManager: TabManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        btnRunAll = findViewById(R.id.btnRunAll)
        btnClearAll = findViewById(R.id.btnClearAll)

        val nativeLib = NativeLib()
        tabManager = TabManager(nativeLib, this)

        tabManager.setupWithViewPager(viewPager, tabLayout)

        btnRunAll.setOnClickListener {
            runAllChecks()
        }

        btnClearAll.setOnClickListener {
            clearAllStatus()
        }
    }

    private fun runAllChecks() {
        for (i in 0 until tabManager.getTabCount()) {
            (supportFragmentManager.findFragmentByTag("f$i") as? TabFragment)?.runAllChecks()
        }
    }

    private fun clearAllStatus() {
        for (i in 0 until tabManager.getTabCount()) {
            (supportFragmentManager.findFragmentByTag("f$i") as? TabFragment)?.clearAllStatus()
        }
    }
}