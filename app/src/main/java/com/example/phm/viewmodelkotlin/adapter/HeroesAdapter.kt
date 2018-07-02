package com.example.phm.viewmodelkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.phm.viewmodelkotlin.R
import com.example.phm.viewmodelkotlin.model.Hero

class HeroesAdapter(private var mCtx:Context, private var heroList:List<Hero>): RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): HeroViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.hero_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        Glide.with(mCtx)
                .load(hero.imageUrl)
                .into(holder.imvHero)

        holder.tvTitleHero.setText(hero.name)
    }

    class HeroViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var imvHero = itemView.findViewById(R.id.imvHero) as ImageView
        var tvTitleHero = itemView.findViewById(R.id.tvTitleHero) as TextView
    }

}