package com.example.rahatmenyu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rahatmenyu.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE", "NAME_SHADOWING")
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var adapter: RVAdapter
    lateinit var myList: ArrayList<ItemModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // code area
        myList = arrayListOf()
        for (x in 1..20) {
            val itemModel = ItemModel(
                "Ardmf",
                R.drawable.ic_person,
                "Lorem ipsum dolor sit."
            )
            myList.add(itemModel)
        }
        val layoutManager = LinearLayoutManager(context)
        binding.recycleView.layoutManager = layoutManager
        binding.recycleView.setHasFixedSize(true)
        adapter = RVAdapter(myList)
        binding.recycleView.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(context, AddActivity::class.java)
            startActivity(intent)
        }

        // code area
        return binding.root
    }

}