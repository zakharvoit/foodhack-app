package zakharvoit.com.foodhackapp.recipedetail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import zakharvoit.com.foodhackapp.R

class EnergyListAdapter(val list: List<String>) : RecyclerView.Adapter<EnergyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.energy_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.view.findViewById<TextView>(R.id.energy_item_text)
        textView.text = list[position]
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
