package com.garibyan.armen.tbc_task_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.garibyan.armen.tbc_task_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var clothesAdapter: ClothesAdapter
    private var list: MutableList<Clothes> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        categoryAdapter = CategoryAdapter(createCategoryList())
        clothesAdapter = ClothesAdapter(list)
        binding.rvCategory.layoutManager = LinearLayoutManager(
            this@MainActivity, LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvCategory.adapter = categoryAdapter

        binding.rvClothes.layoutManager = GridLayoutManager(
            this@MainActivity, 2, GridLayoutManager.VERTICAL, false
        )
        binding.rvClothes.adapter = clothesAdapter

        categoryAdapter.onCategoryClick = {
            clothesAdapter.clothesList = getFilteredList(it.category)
            clothesAdapter.notifyDataSetChanged()
        }
    }

    private fun getFilteredList(category: CategoryEnum): MutableList<Clothes> {
        val newList = mutableListOf<Clothes>()

        return when (category) {
            CategoryEnum.ALL -> createClothesList()
            else -> {
                createClothesList().forEach { if (it.category == category) newList.add(it) }
                newList
            }
        }
    }

    private fun createCategoryList() = mutableListOf(
        Category(
            R.drawable.ic_all,
            getString(R.string.all), CategoryEnum.ALL
        ), Category(
            R.drawable.party,
            getString(R.string.party), CategoryEnum.PARTY
        ), Category(
            R.drawable.camping,
            getString(R.string.camping), CategoryEnum.CAMPING
        ), Category(
            R.drawable.casual,
            getString(R.string.casual), CategoryEnum.CASUAL
        ), Category(
            R.drawable.sport,
            getString(R.string.sport), CategoryEnum.SPORT
        ), Category(
            R.drawable.summer,
            getString(R.string.summer), CategoryEnum.SUMMER
        )
    )

    private fun createClothesList() = mutableListOf(
//        party
        Clothes(
            R.drawable.party1, getString(R.string.party_title_1),
            getString(R.string.price), CategoryEnum.PARTY
        ),
        Clothes(
            R.drawable.party2, getString(R.string.party_title_2),
            getString(R.string.price), CategoryEnum.PARTY
        ),
        Clothes(
            R.drawable.party3, getString(R.string.party_title_3),
            getString(R.string.price), CategoryEnum.PARTY
        ),
        Clothes(
            R.drawable.party4, getString(R.string.party_title_4),
            getString(R.string.price), CategoryEnum.PARTY
        ),
//        Camping
        Clothes(
            R.drawable.camping1, getString(R.string.camping_title_1),
            getString(R.string.price), CategoryEnum.CAMPING
        ),
        Clothes(
            R.drawable.camping2, getString(R.string.camping_title_2),
            getString(R.string.price), CategoryEnum.CAMPING
        ),
        Clothes(
            R.drawable.camping3, getString(R.string.camping_title_3),
            getString(R.string.price), CategoryEnum.CAMPING
        ),
        Clothes(
            R.drawable.camping4, getString(R.string.camping_title_4),
            getString(R.string.price), CategoryEnum.CAMPING
        ),
//        Casual
        Clothes(
            R.drawable.casual1, getString(R.string.casual_title_1),
            getString(R.string.price), CategoryEnum.CASUAL
        ),
        Clothes(
            R.drawable.casual2, getString(R.string.casual_title_2),
            getString(R.string.price), CategoryEnum.CASUAL
        ),
        Clothes(
            R.drawable.casual3, getString(R.string.casual_title_3),
            getString(R.string.price), CategoryEnum.CASUAL
        ),
        //Sport
        Clothes(
            R.drawable.sport1, getString(R.string.sport_title_1),
            getString(R.string.price), CategoryEnum.SPORT
        ),
        Clothes(
            R.drawable.sport2, getString(R.string.sport_title_2),
            getString(R.string.price), CategoryEnum.SPORT
        ),
        Clothes(
            R.drawable.sport3, getString(R.string.sport_title_3),
            getString(R.string.price), CategoryEnum.SPORT
        ),
        Clothes(
            R.drawable.sport4, getString(R.string.sport_title_4),
            getString(R.string.price), CategoryEnum.SPORT
        ),
        //Summer
        Clothes(
            R.drawable.summer1, getString(R.string.summer_title_1),
            getString(R.string.price), CategoryEnum.SUMMER
        ),
        Clothes(
            R.drawable.summer2, getString(R.string.summer_title_2),
            getString(R.string.price), CategoryEnum.SUMMER
        ),
        Clothes(
            R.drawable.summer3, getString(R.string.summer_title_3),
            getString(R.string.price), CategoryEnum.SUMMER
        )
    )

}