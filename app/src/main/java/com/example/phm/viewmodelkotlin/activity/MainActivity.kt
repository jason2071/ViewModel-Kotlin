package com.example.phm.viewmodelkotlin.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.phm.viewmodelkotlin.R
import com.example.phm.viewmodelkotlin.adapter.HeroesAdapter
import com.example.phm.viewmodelkotlin.model.Hero
import com.example.phm.viewmodelkotlin.model.HeroViewModel
import com.example.phm.viewmodelkotlin.util.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders
                .of(this)
                .get(HeroViewModel()::class.java)

        model.getHeroes().observe(this, object : Observer<List<Hero>> {
            override fun onChanged(heroList: List<Hero>?) {
                adapter = HeroesAdapter(this@MainActivity, heroList!!)
                recyclerView.adapter = adapter


                recyclerView.addOnItemTouchListener(RecyclerTouchListener(
                        applicationContext,
                        recyclerView,
                        object : RecyclerTouchListener.ClickListener {
                            override fun onClick(view: View, position: Int) {
                                var hero = heroList[position]
                                Toast.makeText(
                                        applicationContext,
                                        "${hero.name} is onClick!",
                                        Toast.LENGTH_SHORT
                                ).show()
                            }

                            override fun onLongClick(view: View?, position: Int) {
                                var hero = heroList[position]
                                Toast.makeText(
                                        applicationContext,
                                        "${hero.name} is onLongClick!",
                                        Toast.LENGTH_SHORT
                                ).show()
                            }

                        }
                ))


            }
        })
    }
}
