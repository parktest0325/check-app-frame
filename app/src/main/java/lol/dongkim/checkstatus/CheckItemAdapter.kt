package lol.dongkim.checkstatus

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class CheckItemAdapter(private val items: List<CheckItem>) : RecyclerView.Adapter<CheckItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItemName: TextView = view.findViewById(R.id.tvItemName)
        val btnRun: Button = view.findViewById(R.id.btnRun)
        val itemLayout: LinearLayout = view.findViewById(R.id.itemLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_check, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvItemName.text = item.name
        holder.btnRun.setOnClickListener {
            if (item.status == null) {
                runCheck(item, holder, position)
            } else {
                clearCheck(item, holder)
            }
        }
        updateStatus(item, holder)
    }

    override fun getItemCount() = items.size

    private fun runCheck(item: CheckItem, holder: ViewHolder, position: Int) {
        val result = item.checkFunction(position)
        item.status = if (result) CheckStatus.PASS else CheckStatus.FAIL
        updateStatus(item, holder)
    }

    private fun clearCheck(item: CheckItem, holder: ViewHolder) {
        item.status = null
        updateStatus(item, holder)
    }

    private fun updateStatus(item: CheckItem, holder: ViewHolder) {
        when (item.status) {
            CheckStatus.PASS -> {
                holder.itemLayout.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.pass_background))
                holder.btnRun.text = "Clear"
            }
            CheckStatus.FAIL -> {
                holder.itemLayout.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.fail_background))
                holder.btnRun.text = "Clear"
            }
            null -> {
                holder.itemLayout.setBackgroundColor(Color.TRANSPARENT)
                holder.btnRun.text = "Run"
            }
        }
    }

    fun runAllChecks() {
        items.forEachIndexed { index, item ->
            item.status = if (item.checkFunction(index)) CheckStatus.PASS else CheckStatus.FAIL
        }
        notifyDataSetChanged()
    }

    fun clearAllStatus() {
        items.forEach { item ->
            item.status = null
        }
        notifyDataSetChanged()
    }
}