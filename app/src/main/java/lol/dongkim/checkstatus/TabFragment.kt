package lol.dongkim.checkstatus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TabFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CheckItemAdapter

    companion object {
        private const val ARG_TAB_POSITION = "tab_position"

        fun newInstance(tabPosition: Int): TabFragment {
            val fragment = TabFragment()
            val args = Bundle()
            args.putInt(ARG_TAB_POSITION, tabPosition)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)

        val tabPosition = arguments?.getInt(ARG_TAB_POSITION) ?: 0
        val tabManager = (activity as? MainActivity)?.tabManager ?: return
        val initializer = tabManager.getInitializer(tabPosition)

        adapter = CheckItemAdapter(initializer.getItems())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun runAllChecks() {
        adapter.runAllChecks()
    }

    fun clearAllStatus() {
        adapter.clearAllStatus()
    }
}