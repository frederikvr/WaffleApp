package com.frederikvr.waffleapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frederikvr.waffleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvWaffles1 = findViewById<View>(R.id.waffle_list) as RecyclerView

        // Init itemstosell
        var waffleList = mutableListOf<WaffleItem>()
        var waffle1 = WaffleItem("Zalm",1,0, Color.RED)
        var waffle2 = WaffleItem("Banaan",2,0, Color.BLUE)
        var waffle3 = WaffleItem("Kiwi", 10,0, Color.BLACK)
        waffleList.add(waffle1)
        waffleList.add(waffle2)
        waffleList.add(waffle3)

        val adapter = WaffleAdapter(waffleList)

        rvWaffles1.adapter = adapter
        rvWaffles1.layoutManager = LinearLayoutManager(this)


        val rvWaffles2 = findViewById<View>(R.id.waffle_list2) as RecyclerView
        var waffleList2 = mutableListOf<WaffleItem>()
        var waffle21 = WaffleItem("Duvel",1,0, Color.RED)
        var waffle22 = WaffleItem("Jupiler",2,0, Color.CYAN)
        var waffle23 = WaffleItem("Chimay", 10,0, Color.BLUE)
        waffleList2.add(waffle21)
        waffleList2.add(waffle22)
        waffleList2.add(waffle23)

        val adapter2 = WaffleAdapter(waffleList2)
        rvWaffles2.adapter = adapter2
        rvWaffles2.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()

    }
}
