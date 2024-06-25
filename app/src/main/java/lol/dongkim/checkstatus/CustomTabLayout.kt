package lol.dongkim.checkstatus

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import com.google.android.material.tabs.TabLayout

class CustomTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    private val indicatorPaint = Paint().apply {
        color = Color.BLUE // 원하는 색상으로 변경 가능
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (tabCount > 0 && !allTabsVisible()) {
            // 마지막 탭의 오른쪽 끝에 표시를 그립니다
            val lastTab = getTabAt(tabCount - 1)
            lastTab?.let {
                val tabView = it.view
                val right = tabView.right.toFloat()
                val top = tabView.top.toFloat()
                val bottom = tabView.bottom.toFloat()
                val indicatorWidth = 10f // 표시의 너비

                canvas.drawRect(right - indicatorWidth, top, right, bottom, indicatorPaint)
            }
        }
    }

    private fun allTabsVisible(): Boolean {
        val firstTab = getTabAt(0)?.view
        val lastTab = getTabAt(tabCount - 1)?.view
        return firstTab != null && lastTab != null &&
                firstTab.left >= 0 && lastTab.right <= width
    }
}