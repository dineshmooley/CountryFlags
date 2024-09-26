package com.example.assignment9.flag


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment9.databinding.FlagItemBinding
import com.example.assignment9.network.Countries
import com.example.assignment9.network.CountriesContainer

class FlagAdapter(
    private val countries: CountriesContainer
) : RecyclerView.Adapter<FlagAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FlagItemBinding.inflate(layoutInflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countries.data.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.apply {
            flag.text = countries.data[position].unicodeFlag
            countryName.text = countries.data[position].name
        }
    }

    class CountryViewHolder(val binding: FlagItemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}
