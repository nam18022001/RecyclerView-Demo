package com.example.recycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val exampleList = ganerateDummyList(4)
    private val adapter = ExampleAdapter(exampleList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler_view.setHasFixedSize(true)

        btnInsert.setOnClickListener {
            insertItem()
        }

    }
    fun insertItem(){
        val index = Random.nextInt(2)

        val newItem = ExampleItem(R.drawable.ic_baseline_4k_24, "Hehe ", "19")
        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)

    }
    fun deleteItem(view: View){

    }
    fun ganerateDummyList (size : Int) : ArrayList<ExampleItem>
    {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {

            val item = ExampleItem(R.drawable.ic_baseline_4k_24, "Item $i", "Line 2")
            list += item
        }
        return list
    }

}