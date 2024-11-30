package com.chalco.jose.poketinder.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chalco.jose.poketinder.data.database.entities.MyPokemonEntity
import com.chalco.jose.poketinder.databinding.ItemPokemonSavedBinding

class MyPokemonsAdapter(val list: List<MyPokemonEntity>): RecyclerView.Adapter<MyPokemonsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = ItemPokemonSavedBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        return MyPokemonsHolder(view.root)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val pokemon = list[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = list.size
}
