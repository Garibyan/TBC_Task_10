package com.garibyan.armen.tbc_task_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garibyan.armen.tbc_task_10.databinding.RvClothesItemBinding

class ClothesAdapter(var clothesList: MutableList<Clothes>) :
    RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder>() {

    inner class ClothesViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = RvClothesItemBinding.bind(item)
        fun bind(clothes: Clothes) = with(binding) {
            itemImage.setBackgroundResource(clothes.imageSrc)
            itemtitle.text = clothes.title
            itemPrice.text = clothes.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.rv_clothes_item, parent, false)
        return ClothesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        holder.bind(clothesList[position])
    }

    override fun getItemCount() = clothesList.size

}