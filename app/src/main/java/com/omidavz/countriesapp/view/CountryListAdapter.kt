package com.omidavz.countriesapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omidavz.countriesapp.R
import com.omidavz.countriesapp.databinding.ItemCountryBinding
import com.omidavz.countriesapp.model.Country

class CountryListAdapter(private var countries : ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    lateinit var binding : ItemCountryBinding

    fun updateCountries(newCountries : List<Country>){
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_country,parent,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country : Country = countries[position]

        holder.bind(country)

//        binding.imageView.loadImage(country.flag , holder.progressDrawable)

    }

    class CountryViewHolder(private val binding : ItemCountryBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(country: Country){
            binding.country = country
        }

    }

}