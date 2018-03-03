package zakharvoit.com.foodhackapp.recipelist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import zakharvoit.com.foodhackapp.R
import zakharvoit.com.foodhackapp.databinding.RecipeListItemBinding
import zakharvoit.com.foodhackapp.model.RecipePreview

class RecipeListAdapter() : RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {
    val isLoading = true
    var list = ArrayList<RecipePreview>()
        set(value) { field.clear(); field.addAll(value); notifyDataSetChanged(); }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ViewHolder(
                DataBindingUtil.inflate(inflater, R.layout.recipe_list_item, parent,false)
        )
        holder.binding.viewModel = RecipeListItemViewModel()
        return holder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel?.recipe = list[position]
    }

    class ViewHolder(val binding: RecipeListItemBinding) : RecyclerView.ViewHolder(binding.root)
}