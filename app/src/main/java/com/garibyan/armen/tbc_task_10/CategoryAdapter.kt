package com.garibyan.armen.tbc_task_10

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garibyan.armen.tbc_task_10.databinding.RvCategoryItemBinding

class CategoryAdapter(private val categoryList: MutableList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var onCategoryClick: ((Category) -> Unit)? = null

    inner class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = RvCategoryItemBinding.bind(item)
        fun bind(category: Category) = with(binding) {
            itemImg.setBackgroundResource(category.imageSrc)
            itemText.text = category.title

            binding.root.setOnClickListener {
                d("mylog", category.category.toString())
                onCategoryClick?.invoke(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount() = categoryList.size

}